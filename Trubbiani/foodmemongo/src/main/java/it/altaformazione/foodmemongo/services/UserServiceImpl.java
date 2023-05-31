package it.altaformazione.foodmemongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

import it.altaformazione.foodmemongo.models.User;
import it.altaformazione.foodmemongo.models.dtos.OrderDTO;
import it.altaformazione.foodmemongo.models.dtos.UserDTO;
import it.altaformazione.foodmemongo.repositories.OrderRepository;
import it.altaformazione.foodmemongo.repositories.UserRepository;
import it.altaformazione.foodmemongo.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final OrderRepository orderRepository;
        private final MongoTemplate mongoTemplate;

        public UserServiceImpl(
                        UserRepository userRepository,
                        OrderRepository orderRepository,
                        MongoTemplate mongoTemplate) {
                this.userRepository = userRepository;
                this.mongoTemplate = mongoTemplate;
                this.orderRepository = orderRepository;
        }

        @Override
        public List<User> getAll() {
                return this.userRepository.findAll();
        }

        @Override
        public UserDTO getById(String id) throws Exception {
                List<String> ordersId = this.orderRepository.findOrdersByUserId(id)
                                .stream()
                                .map(o -> o.getId())
                                .collect(Collectors.toList());
                return this.userRepository.findById(id)
                                .map(user -> UserDTO.builder()
                                                .id(user.getId())
                                                .name(user.getName())
                                                .email(user.getEmail())
                                                .gender(user.getGender())
                                                .age(user.getAge())
                                                .orders(ordersId)
                                                .build())
                                .orElseThrow(Exception::new);
        }

        @Override
        public User create(UserDTO userDTO) {
                return this.userRepository.save(
                                User.builder()
                                                .name(userDTO.getName())
                                                .email(userDTO.getEmail())
                                                .mobile(userDTO.getMobile())
                                                .gender(userDTO.getGender())
                                                .age(userDTO.getAge())
                                                .build()

                );
        }

        @Override
        public List<UserDTO> getUserByGender(String gender, int age) throws Exception {

                Criteria criteria = new Criteria();
                criteria.and("gender").is(gender);
                criteria.and("age").gt(age);
                Query query = new Query(criteria);
                // query.addCriteria(Criteria.where("age").gt(age));
                return mongoTemplate.find(query, User.class)
                                .stream()
                                .map(user -> UserDTO.builder()
                                                .id(user.getId())
                                                .name(user.getName())
                                                .email(user.getEmail())
                                                .gender(user.getGender())
                                                .age(user.getAge())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Override
        public List<OrderDTO> getUserOrders(String userId) {
                return this.orderRepository.findOrdersByUserId(userId)
                                .stream().map(order -> OrderDTO.builder().id(order.getId())
                                                .total(order.getTotal())
                                                .userId(userId).build())
                                .collect(Collectors.toList());
        }

        @Override
        public boolean updateUserOrders(String userId, String orderId) throws Exception {
                Update update = new Update().push("orderIds", orderId);
                Query query = new Query(Criteria.where("_id").is(userId));
                UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);

                // Per aggiornare piu oggetti possiamo usare
                // Update update = new Update().set("orderIdY", "orderIdX");
                // Query query = new Query(Criteria.where("userId").is(userId));
                // UpdateResult updateResult = mongoTemplate.updateMulti(query, update,
                // User.class);

                return updateResult.getModifiedCount() > 0 ? true : false;
        }

}

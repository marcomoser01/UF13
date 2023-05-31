package it.altaformazione.foodmemongo.services.interfaces;

import java.util.List;

import it.altaformazione.foodmemongo.models.User;
import it.altaformazione.foodmemongo.models.dtos.OrderDTO;
import it.altaformazione.foodmemongo.models.dtos.UserDTO;

public interface UserService {
    List<User> getAll();

    UserDTO getById(String id) throws Exception;

    User create(UserDTO userDTO);

    List<UserDTO> getUserByGender(String gender, int age) throws Exception;

    List<OrderDTO> getUserOrders(String userId);

    boolean updateUserOrders(String userId, String orderId) throws Exception;
}

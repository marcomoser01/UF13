package it.altaformazione.foodmemongo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import it.altaformazione.foodmemongo.models.Order;

import java.util.List;

@Repository
public class OrderRepository {
    private final MongoTemplate mongoTemplate;

    public OrderRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Order> findOrdersByUserId(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        return mongoTemplate.find(query, Order.class);
    }
}
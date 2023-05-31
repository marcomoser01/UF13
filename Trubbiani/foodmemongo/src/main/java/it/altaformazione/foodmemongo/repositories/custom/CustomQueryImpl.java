package it.altaformazione.foodmemongo.repositories.custom;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import it.altaformazione.foodmemongo.models.Product;

public class CustomQueryImpl implements CustomQuery {
    
    private final MongoTemplate mongoTemplate;

    public CustomQueryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
    public List<Product> findProductById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, Product.class);
    }


}

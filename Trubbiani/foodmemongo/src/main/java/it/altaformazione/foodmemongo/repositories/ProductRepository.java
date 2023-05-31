package it.altaformazione.foodmemongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.altaformazione.foodmemongo.models.Product;
import it.altaformazione.foodmemongo.repositories.custom.CustomQuery;

public interface ProductRepository extends MongoRepository<Product, String>, CustomQuery {
    List<Product> findByName(String name);

}

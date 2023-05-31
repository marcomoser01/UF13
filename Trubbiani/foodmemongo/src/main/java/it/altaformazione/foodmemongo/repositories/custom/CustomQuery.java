package it.altaformazione.foodmemongo.repositories.custom;

import java.util.List;

import it.altaformazione.foodmemongo.models.Product;

public interface CustomQuery {
    
    public List<Product> findProductById(String id);
    

}

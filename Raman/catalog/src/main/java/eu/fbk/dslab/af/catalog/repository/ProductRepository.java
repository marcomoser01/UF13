package eu.fbk.dslab.af.catalog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import eu.fbk.dslab.af.catalog.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

    Page<Product> findByCategory(String category, Pageable page);
    
}

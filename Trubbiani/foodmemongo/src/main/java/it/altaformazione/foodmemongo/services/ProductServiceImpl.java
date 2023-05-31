package it.altaformazione.foodmemongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

import it.altaformazione.foodmemongo.models.Product;
import it.altaformazione.foodmemongo.models.dtos.ProductDTO;
import it.altaformazione.foodmemongo.repositories.ProductRepository;
import it.altaformazione.foodmemongo.repositories.UserRepository;
import it.altaformazione.foodmemongo.services.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;

    public ProductServiceImpl(ProductRepository productRepository, MongoTemplate mongoTemplate) {
        this.productRepository = productRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getImmage());
        return this.productRepository.save(product);
    }

    @Override
    public ProductDTO getByID(String id) throws Exception {
        return this.productRepository.findById(id)
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .immage(product.getImmage())
                        .build())
                .orElseThrow(Exception::new);
    }

    @Override
    public List<ProductDTO> getProductsByName(String name) throws Exception {
        return this.productRepository.findByName(name)
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .immage(product.getImmage())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProductsPrice(String productsId, float price) throws Exception {
        Update update = new Update().set("price", price);
        Query query = new Query(Criteria.where("id").is(productsId));
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Product.class);
        //UpdateResult updateResult = mongoTemplate.updateMulti(query,update, Product.class);

        // Per aggiornare piu oggetti possiamo usare
        // Update update = new Update().set("orderIdY", "orderIdX");
        // Query query = new Query(Criteria.where("userId").is(userId));
        // UpdateResult updateResult = mongoTemplate.updateMulti(query, update,
        // User.class);

        return getByID(productsId);
    }

}

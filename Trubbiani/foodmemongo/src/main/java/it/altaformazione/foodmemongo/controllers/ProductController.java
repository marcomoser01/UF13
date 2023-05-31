package it.altaformazione.foodmemongo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.altaformazione.foodmemongo.models.Product;
import it.altaformazione.foodmemongo.models.dtos.ProductDTO;
import it.altaformazione.foodmemongo.services.interfaces.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("")
    public ResponseEntity<List<Product>> products() {
        return new ResponseEntity<List<Product>>(
            this.productService.getAll(), HttpStatus.OK
        );

    }

    @PostMapping("")
    public ResponseEntity<Product> products(@RequestBody ProductDTO userDTO) {

        return new ResponseEntity<Product>(
                this.productService.create(userDTO), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> productByName(@PathVariable String name) {

        try {
            return new ResponseEntity<List<ProductDTO>>(
                    this.productService.getProductsByName(name), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> products(@RequestBody Map<String, Object> price, @PathVariable String id) {
        try{
            return new ResponseEntity<ProductDTO>(
                this.productService.updateProductsPrice(id, Float.parseFloat(price.get("price").toString())), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

    }



}

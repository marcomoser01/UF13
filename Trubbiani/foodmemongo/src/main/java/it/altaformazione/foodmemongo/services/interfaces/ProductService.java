package it.altaformazione.foodmemongo.services.interfaces;

import java.util.List;

import it.altaformazione.foodmemongo.models.Product;
import it.altaformazione.foodmemongo.models.dtos.ProductDTO;

public interface ProductService {

    List<Product> getAll();

    Product create(ProductDTO productDTO);

    ProductDTO getByID(String id) throws Exception;

    List<ProductDTO> getProductsByName(String name) throws Exception;

    ProductDTO updateProductsPrice(String productsId, float price) throws Exception;


}

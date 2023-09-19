package eu.fbk.dslab.af.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eu.fbk.dslab.af.catalog.domain.Product;
import eu.fbk.dslab.af.catalog.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repo;

    public Page<Product> getProducts(Pageable page) {
        return repo.findAll(page);
    }

    public Product getProduct(String id) {
        return repo.findById(id).orElse(null);
    }

    public Page<Product> findProducts(String category, Pageable page) {
        return repo.findByCategory(category,page);
    }

    public Product create(Product product) {
        product.setId(null);
        return save(product);
    }

    public Product changeQuantity(String id, int amount) {

        Product p = getProduct(id);
        if (p != null) {
            p.setQuantity(p.getQuantity() - amount);
            p = save(p);
        }
        return p;
    }

    public Product save(Product prod) {
        return repo.saveAndFlush(prod);
    }
}

// package eu.fbk.dslab.af.catalog.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import eu.fbk.dslab.af.catalog.domain.Product;
// import eu.fbk.dslab.af.catalog.repository.ProductJpaRepository; // Usa il nuovo repository JPA

// @Service
// public class ProductService {
    
//     @Autowired
//     private ProductJpaRepository repo; // Usa il nuovo repository JPA

//     public Page<Product> getProducts(Pageable page) {
//         return repo.findAll(page);
//     }

//     public Product getProduct(Long id) { // Modifica il tipo dell'ID in base alla tua entità
//         return repo.findById(id).orElse(null);
//     }

//     public Page<Product> findProducts(String category, Pageable page) {
//         return repo.findByCategory(category, page);
//     }

//     public Product create(Product product) {
//         product.setId(null);
//         return repo.save(product);
//     }

//     public Product changeQuantity(Long id, int amount) { // Modifica il tipo dell'ID in base alla tua entità

//         Product p = getProduct(id);
//         if (p != null) {
//             p.setQuantity(p.getQuantity() - amount);
//             p = repo.save(p);
//         }
//         return p;
//     }
// }


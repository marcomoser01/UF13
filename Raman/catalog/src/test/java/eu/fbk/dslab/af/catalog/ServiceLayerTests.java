package eu.fbk.dslab.af.catalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.Assert;

import eu.fbk.dslab.af.catalog.domain.Product;
import eu.fbk.dslab.af.catalog.repository.ProductRepository;
import eu.fbk.dslab.af.catalog.service.ProductService;

@SpringBootTest
@DirtiesContext
public class ServiceLayerTests {
    
    @Autowired
    private ProductRepository repo;

    @Autowired
    private ProductService service;

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
    }

    @Test
    public void testProductService() {
        Product p = new Product();
        p.setCategory("category");
        p.setDescription("description");
        p.setTitle("title");
        p.setQuantity(100);
        p.setPrice(10.0);

        Product createdProduct = service.create(p);
        Assert.notNull(createdProduct, "Product has not been created");
        Assert.notNull(createdProduct.getId(), "ID is not null");
        Assert.notNull(createdProduct.getTitle().equals("title"), "Message title invalid");

        Product readProduct = service.getProduct(createdProduct.getId());
        Assert.notNull(readProduct, "Product has not been read");

        Page<Product> page = service.findProducts("category", PageRequest.of(0,10));
        Assert.notNull(page, "Page is null");
        Assert.isTrue(page.hasContent(), "Page has content");

        service.changeQuantity(createdProduct.getId(), 10);
        readProduct = service.getProduct(createdProduct.getId());
        Assert.isTrue(readProduct.getQuantity() == p.getQuantity() -10, "Wrong quantity");

        Product changed = service.changeQuantity("123", 20);
        Assert.isNull(changed, "Object shoul be null but is not");

    }


}

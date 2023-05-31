package eu.fbk.dslab.af.catalog;

import java.util.Optional;

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

@SpringBootTest
@DirtiesContext
public class DataLayerTests {

    @Autowired
    private ProductRepository repo;

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
    }

    @Test
    public void testDataLayer() {
        Product p = new Product();
        p.setCategory("category");
        p.setDescription("description");
        p.setTitle("title");
        p.setQuantity(100);
        p.setPrice(10.0);

        Product createdProduct = repo.save(p);
        Assert.notNull(createdProduct, "Product has not been created");
        Assert.notNull(createdProduct.getId(), "ID is not null");
        Assert.notNull(createdProduct.getTitle().equals("title"), "Message title invalid");

        Optional<Product> read = repo.findById(createdProduct.getId());
        Assert.isTrue((read.isPresent()), "Object not found");

        Page<Product> page = repo.findByCategory("category", PageRequest.of(0, 10));
        Assert.notNull(page, "Page is null");
        Assert.isTrue(page.hasContent(), "Page has content");
        Assert.isTrue(page.getContent().size() == 1, "Wrong lenght");

        page = repo.findByCategory("category2", PageRequest.of(0, 10));
        Assert.notNull(page, "Page is null");
        Assert.isTrue(!page.hasContent(), "Page has content, but should not");


    }
}

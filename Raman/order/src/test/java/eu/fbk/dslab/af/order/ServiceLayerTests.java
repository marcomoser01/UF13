package eu.fbk.dslab.af.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.Assert;

import eu.fbk.dslab.af.order.domain.Order;
import eu.fbk.dslab.af.order.domain.ProductObject;
import eu.fbk.dslab.af.order.repository.OrderRepository;
import eu.fbk.dslab.af.order.service.OpenFeignCatalogService;
import eu.fbk.dslab.af.order.service.OrderService;

@DirtiesContext
@SpringBootTest
public class ServiceLayerTests {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderService service;

    @MockBean
    private OpenFeignCatalogService catalogService;
    
    @BeforeEach
    public void setUp() {
        repo.deleteAll();
        ProductObject p = new ProductObject();
        p.setCategory("category");
        p.setDescription("desc");
        p.setTitle("title");
        p.setPrice(10.0);
        p.setId("123");
        Mockito.when(catalogService.getProductFromCatalog("123"))
            .thenReturn(p);

    }

    @Test
    public void testOrderservice() {
        Order order = service.createOrder("1", "123", 3);
        Assert.notNull(order, "Order is null");
        Assert.isTrue(order.getProductTitle().equals("title"), "Wrong title");
        Assert.isTrue(order.getTotal().equals(30.0), "Wrong total cost");
    }


}

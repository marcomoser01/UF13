package eu.fbk.dslab.af.catalog;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.fbk.dslab.af.catalog.domain.Product;
import eu.fbk.dslab.af.catalog.repository.ProductRepository;

@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest
public class RestLayerTests {
    
    @Autowired
    private ProductRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }


    @Test
    public void testProductController() throws Exception {
        Product p = new Product();
        p.setCategory("category");
        p.setDescription("description");
        p.setTitle("title");
        p.setQuantity(100);
        p.setPrice(10.0);


        RequestBuilder postRequest = MockMvcRequestBuilders.post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(p));

        MvcResult result = mockMvc.perform(postRequest)
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is(p.getTitle())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.category", Matchers.is(p.getCategory())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is(p.getDescription())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.quantity", Matchers.is(p.getQuantity())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(p.getPrice())))
            .andReturn();

        






    }




}

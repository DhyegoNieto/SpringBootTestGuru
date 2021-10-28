package io.boot.test.controller;

import io.boot.test.model.Product;
import io.boot.test.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "P001", "Toy", 23.8D, "A cool toy"));
        products.add(new Product(2L, "P002", "Book", 33.8D, "A cool book"));
        products.add(new Product(3L, "P003", "PC", 223.8D, "A cool pc"));

        given(productService.getAll()).willReturn(products);

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void givenProductService_thenGetAll() throws Exception {

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].code", is("P001")))
                .andExpect(jsonPath("$.[1].code", is("P002")));
    }
}

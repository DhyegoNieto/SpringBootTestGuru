package io.unitary.web;

import io.unitary.controller.ProductController;
import io.unitary.model.Product;
import io.unitary.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class StandaloneControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Map<String, Object> model;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    List<Product> products = new ArrayList<>();

    @BeforeEach
    public void setup() {
        products.add(new Product(1L, "Clock", "A cool clock", "P001"));
        products.add(new Product(2L, "Mouse", "A cool mouse", "P002"));

        given(productService.getAll()).willReturn(products);

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testControllerGetAll() throws Exception {
        mockMvc.perform(get("/api/v1/products/all"))
                .andExpect(status().isOk())
                .andReturn();
    }
}

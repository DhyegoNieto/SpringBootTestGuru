package io.boot.test.controller;

import io.boot.test.model.Product;
import io.boot.test.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    private Product product;

    @BeforeEach
    public void setup() {
        product = Product.builder()
                .id(1L)
                .code("P001")
                .name("Computer")
                .price(333.9)
                .description("A cool computer")
                .build();
    }

    @AfterEach
    void tearDown() {
        reset(productService);
    }

    @Test
    public void testGetProductById() throws Exception {
        given(productService.getById(anyLong())).willReturn(product);

        MvcResult result = mockMvc.perform(get("/api/v1/products/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();

        assertThat(contentAsString).contains("P001");
    }
}

package io.boot.test.controller;

import io.boot.test.model.Product;
import io.boot.test.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUsingRestTemplate {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductService productService;

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
    public void tearDown() {
        reset(productService);
    }

    @Test
    public void testGetById() {

        given(productService.getById(anyLong())).willReturn(product);

        Product product = testRestTemplate.getForObject("/api/v1/products/{id}", Product.class, 1L);

        assertThat(product.getName()).isEqualTo("Computer");
    }
}

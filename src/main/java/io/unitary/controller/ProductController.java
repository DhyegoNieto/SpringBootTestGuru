package io.unitary.controller;

import io.unitary.model.Product;
import io.unitary.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        model.put("products", products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<List<Product>> getByName(Product product) {
        List<Product> products = null;
        if(product.getCode().equalsIgnoreCase("P001")) {
            products = productService.getAll();
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

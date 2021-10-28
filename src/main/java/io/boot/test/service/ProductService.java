package io.boot.test.service;

import io.boot.test.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getAll();

    Product save(Product product);

    void deleteById(Long id);

    Product getById(Long id);
}

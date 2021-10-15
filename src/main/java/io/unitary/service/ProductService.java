package io.unitary.service;

import io.unitary.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product getById(Long id);

    List<Product> getAll();

    Product create(Product product);

    Product update(Product product, Long id);
}

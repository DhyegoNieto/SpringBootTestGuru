package io.boot.test.service.impl;

import io.boot.test.model.Product;
import io.boot.test.repository.ProductJpaRepository;
import io.boot.test.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> getAll() {
        List<Product> products = productJpaRepository.findAll();

        if(products.size() > 0) {
            return products;
        }
        throw new RuntimeException("No products at all!");
    }

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public Product getById(Long id) {
        return productJpaRepository.getById(id);
    }
}

package io.unitary.service.impl;

import io.unitary.model.Product;
import io.unitary.service.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile("web")
@Service
public class ProducServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1L, "Clock", "A cool clock", "P001"));
        products.add(new Product(2L, "Mouse", "A cool mouse", "P002"));
        products.add(new Product(3L, "Cell", "A cool cell", "P003"));
        products.add(new Product(4L, "PC", "A cool pc", "P004"));
        products.add(new Product(5L, "XBOX", "A cool xbox", "P005"));
        products.add(new Product(6L, "TV", "A cool tv", "P006"));
        products.add(new Product(7L, "Freezer", "A cool freezer", "P007"));
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> optProduct = products.stream()
                .filter(item -> item.getId() == id)
                .findFirst();

        return optProduct.orElseThrow(() ->{
            return new RuntimeException("Product not found " + id);
        });
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product create(Product product) {
        return product;
    }

    @Override
    public Product update(Product product, Long id) {
        return products.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
    }
}

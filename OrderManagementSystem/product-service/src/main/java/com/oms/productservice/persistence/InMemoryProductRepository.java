package com.oms.productservice.persistence;

import com.oms.productservice.domain.Product;
import com.oms.productservice.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private static final Map<String, Product> products = new ConcurrentHashMap<>();

    @Override
    public Iterable<Product> findAll() {
        return products.values();
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return existsBySku(sku) ? Optional.of(products.get(sku)) : Optional.empty();
    }

    @Override
    public boolean existsBySku(String sku) {
        return products.get(sku) != null;
    }

    @Override
    public Product save(Product product) {
        return products.put(product.sku(), product);
    }

    @Override
    public void deleteBySku(String sku) {
        products.remove(sku);
    }
}

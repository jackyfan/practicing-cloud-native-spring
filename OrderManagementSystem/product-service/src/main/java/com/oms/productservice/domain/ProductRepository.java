package com.oms.productservice.domain;

import java.util.Optional;

public interface ProductRepository {
    Iterable<Product> findAll();

    Optional<Product> findBySku(String sku);

    boolean existsBySku(String sku);

    Product save(Product product);

    void deleteBySku(String sku);
}

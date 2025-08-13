package com.oms.productservice.demo;

import com.oms.productservice.domain.Product;
import com.oms.productservice.domain.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class ProductDataLoader {
    private final ProductRepository productRepository;

    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        productRepository.deleteAll();
        var product1 = Product.of("T0001", "TCL电视机", 199.90);
        var product2 = Product.of("T0002", "华为手机Mate70", 199.90);
        productRepository.saveAll(List.of(product1, product2));
    }
}

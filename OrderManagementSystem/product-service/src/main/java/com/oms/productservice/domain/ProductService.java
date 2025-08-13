package com.oms.productservice.domain;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> viewProductList() {
        return productRepository.findAll();
    }

    public Product viewProductDetails(String sku) {
        return productRepository.findBySku(sku)
                .orElseThrow(() -> new ProductNotFoundException(sku));
    }

    public Product addProductToCatalog(Product Product) {
        if (productRepository.existsBySku(Product.sku())) {
            throw new ProductAlreadyExistsException(Product.sku());
        }
        return productRepository.save(Product);
    }

    public void removeProduct(String sku) {
        productRepository.deleteBySku(sku);

    }

    public Product editProductDetails(String sku, Product Product) {
        return productRepository.findBySku(sku)
                .map(existingProduct -> {
                    var ProductToUpdate = new Product(
                            existingProduct.id(),
                            existingProduct.sku(),
                            Product.name(),
                            Product.price(),
                            0,
                            existingProduct.createdDate(),
                            existingProduct.lastModifiedDate());
                    return productRepository.save(ProductToUpdate);
                })
                .orElseGet(() -> addProductToCatalog(Product));
    }
}
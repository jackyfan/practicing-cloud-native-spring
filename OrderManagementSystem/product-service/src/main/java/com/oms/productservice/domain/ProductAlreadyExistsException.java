package com.oms.productservice.domain;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String sku) {
        super("A book with SKU " + sku + " already exists.");
    }
}

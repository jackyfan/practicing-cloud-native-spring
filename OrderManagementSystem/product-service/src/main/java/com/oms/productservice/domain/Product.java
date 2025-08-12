package com.oms.productservice.domain;

public record Product(
        String sku,
        String name,
        Double price
) { }

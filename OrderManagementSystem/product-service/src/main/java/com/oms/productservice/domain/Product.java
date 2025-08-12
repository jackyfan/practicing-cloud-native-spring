package com.oms.productservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Product(
        @NotBlank(message = "The product sku must be defined.")
        @Pattern(regexp = "^([A-Z][0-9]{4})$")
        String sku,

        @NotBlank(message = "The product name must be defined.")
        String name,

        @NotNull(message = "The product price must be defined.")
        @Positive(
                message = "The product price must be greater than zero."
        )
        Double price
) {
}

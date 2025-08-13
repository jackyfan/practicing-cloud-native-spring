package com.oms.productservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Product(
        @Id
        Long id,
        @NotBlank(message = "The product sku must be defined.")
        @Pattern(regexp = "^([A-Z][0-9]{4})$")
        String sku,

        @NotBlank(message = "The product name must be defined.")
        String name,

        @NotNull(message = "The product price must be defined.")
        @Positive(
                message = "The product price must be greater than zero."
        )
        Double price,
        @Version
        int version,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate

        ) {
    public static Product of(
            String sku, String name, Double price
    ) {
        return new Product(null, sku, name, price, 0,null,null);
    }
}

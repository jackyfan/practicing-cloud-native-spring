package com.oms.productservice;

import com.oms.productservice.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenBookCreated() {
        var expectedProduct = new Product("A0001", "华为Mate70", 199.99);
        webTestClient
                .post()
                .uri("/products")
                .bodyValue(expectedProduct)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Product.class).value(actualProduct -> {
                    assertThat(actualProduct).isNotNull();
                    assertThat(actualProduct.sku()).isEqualTo(expectedProduct.sku());
                });
    }

}

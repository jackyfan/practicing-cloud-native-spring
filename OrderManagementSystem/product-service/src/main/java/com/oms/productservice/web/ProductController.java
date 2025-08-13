package com.oms.productservice.web;

import com.oms.productservice.domain.Product;
import com.oms.productservice.domain.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> get() {
        return productService.viewProductList();
    }

    @GetMapping("{sku}")
    public Product getBySku(@PathVariable String sku) {
        return productService.viewProductDetails(sku);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product post(@Valid @RequestBody Product product) {
        return productService.addProductToCatalog(product);
    }

    @DeleteMapping("{sku}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String sku) {
        productService.removeProduct(sku);
    }

    @PutMapping("{sku}")
    public Product put(@PathVariable String sku, @Valid @RequestBody Product product) {
        return productService.editProductDetails(sku, product);
    }


}

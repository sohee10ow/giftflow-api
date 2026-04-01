package com.giftflow.api.product;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private static final int TEMP_PRODUCT_ID = 1;

    @PostMapping("/admin-api/v1/products")
    public ProductResponse createProduct(@RequestBody CreateProductRequest request) {
        return new ProductResponse(
                TEMP_PRODUCT_ID,
                request.getName(),
                request.getPrice()
        );
    }
}

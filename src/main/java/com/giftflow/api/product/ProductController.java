package com.giftflow.api.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/admin-api/v1/products")
    public int getProduct(CreateProductRequest product) {
        return 1;
    }

}

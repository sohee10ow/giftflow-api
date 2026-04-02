package com.giftflow.api.product;

import com.giftflow.api.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProductController {
    private static final int TEMP_PRODUCT_ID = 1;

    @PostMapping("/admin-api/v1/products")
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
       ProductResponse response =  new ProductResponse(
                TEMP_PRODUCT_ID,
                request.getName(),
                request.getPrice());

        return ApiResponse.success(response, UUID.randomUUID().toString());

    }
}

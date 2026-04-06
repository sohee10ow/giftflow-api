package com.giftflow.api.product;

import com.giftflow.api.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/admin-api/v1/products")
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        LocalDateTime now = LocalDateTime.now();
        product.setCreatedAt(now);
        product.setUpdatedAt(now);


       ProductEntity saveProduct = productRepository.save(product);


        ProductResponse response =  new ProductResponse(
                saveProduct.getId(),
                saveProduct.getName(),
                saveProduct.getPrice());

        return ApiResponse.success(response, UUID.randomUUID().toString());

    }
    @GetMapping("/admin-api/v1/products/{id}")
    public ApiResponse<ProductResponse> getProduct(@PathVariable long id) {
        ProductEntity product = productRepository.getReferenceById(id);

        ProductResponse response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
        return ApiResponse.success(response, UUID.randomUUID().toString());
    }
}

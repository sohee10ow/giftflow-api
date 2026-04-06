package com.giftflow.api.product;

import com.giftflow.api.common.ApiError;
import com.giftflow.api.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

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
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는데이터입니다."));

        ProductResponse response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
        return ApiResponse.success(response, UUID.randomUUID().toString());
    }

    @GetMapping("/admin-api/v1/products/all")
    public ApiResponse<List<ProductResponse>> getProducts() {
        List<ProductEntity> products = productRepository.findAll();

       List<ProductResponse> data =  products.stream().map(
               value -> new ProductResponse(
                       value.getId(),
                       value.getName(),
                       value.getPrice()
               )
       ).toList();

       return ApiResponse.success(data, UUID.randomUUID().toString());
    }
}

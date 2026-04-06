package com.giftflow.api.product;

public class ProductResponse {

    private Long productId;
    private String name;
    private Integer price;

    public ProductResponse(Long productId, String name, Integer price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
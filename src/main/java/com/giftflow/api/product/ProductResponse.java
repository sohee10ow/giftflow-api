package com.giftflow.api.product;

public class ProductResponse {

    private int productId;
    private String name;
    private Integer price;

    public ProductResponse(int productId, String name, Integer price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
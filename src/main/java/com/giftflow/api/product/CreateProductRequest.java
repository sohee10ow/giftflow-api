package com.giftflow.api.product;

public class CreateProductRequest {
    private String name;
    private int price;
    //기본 생성자
    public CreateProductRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

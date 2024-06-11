package com.example.t2208a_springboot.model.response_model;

public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private Boolean isStock;
    private String description;

    public ProductResponse(Long id, String name, Double price, Boolean isStock, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isStock = isStock;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getStock() {
        return isStock;
    }

    public String getDescription() {
        return description;
    }
}

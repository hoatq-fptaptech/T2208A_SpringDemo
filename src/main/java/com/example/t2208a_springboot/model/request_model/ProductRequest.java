package com.example.t2208a_springboot.model.request_model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Double price;
    private Long qty;
    private String description;
    private Long categoryId;
}

package com.example.t2208a_springboot.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Product")
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String name;
    private Double price;
    private Long qty;
    @Column(columnDefinition = "text")
    private String description;


}

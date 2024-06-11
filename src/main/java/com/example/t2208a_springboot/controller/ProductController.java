package com.example.t2208a_springboot.controller;

import com.example.t2208a_springboot.entity.Product;
import com.example.t2208a_springboot.model.response_model.ProductResponse;
import com.example.t2208a_springboot.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponse> getAllProduct(){
        return productService.getAll();
    }
}

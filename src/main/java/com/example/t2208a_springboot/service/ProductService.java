package com.example.t2208a_springboot.service;

import com.example.t2208a_springboot.entity.Product;
import com.example.t2208a_springboot.model.response_model.ProductResponse;
import com.example.t2208a_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
//    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductResponse> getAll(){
        List<Product> ls = productRepository.findAll();
        List<ProductResponse> rs = ls.stream().map(
                p -> new ProductResponse(
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getQty() > 0,
                        p.getDescription()
                )
        ).toList();
        return rs;
    }
}

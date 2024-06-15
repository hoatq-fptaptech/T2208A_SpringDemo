package com.example.t2208a_springboot.service;

import com.example.t2208a_springboot.entity.Category;
import com.example.t2208a_springboot.entity.Product;
import com.example.t2208a_springboot.model.request_model.ProductRequest;
import com.example.t2208a_springboot.model.response_model.ProductResponse;
import com.example.t2208a_springboot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {
//    @Autowired
    private ProductRepository productRepository;
    private CategoryService categoryService;

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

    public Product createProduct(ProductRequest product){
        Category category = categoryService.find(product.getCategoryId());
        return productRepository.save(new Product(
                null,
                product.getName(),
                product.getPrice(),
                product.getQty(),
                product.getDescription(),
                category,
                null
        ));
    }

    public List<Product> filter(String name,Double minPrice, Double maxPrice){
        return productRepository.search(name,minPrice,maxPrice);
    }
}

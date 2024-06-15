package com.example.t2208a_springboot.controller;

import com.example.t2208a_springboot.entity.Category;
import com.example.t2208a_springboot.entity.Product;
import com.example.t2208a_springboot.model.request_model.ProductRequest;
import com.example.t2208a_springboot.model.response_model.ProductResponse;
import com.example.t2208a_springboot.service.CategoryService;
import com.example.t2208a_springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;
    @GetMapping()
    public List<ProductResponse> getAllProduct(){
        return productService.getAll();
    }
    // Create
    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest model){
        Product product = productService.createProduct(model);
        return ResponseEntity.ok(new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQty()>0,
                product.getDescription()
        ));
    }
    // Update
    // Delete

    public ResponseEntity<List<ProductResponse>>search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
            ){
        return ResponseEntity.ok(productService.filter(name, minPrice, maxPrice)
                .stream().map(
                        p -> new ProductResponse(
                                p.getId(),
                                p.getName(),
                                p.getPrice(),
                                p.getQty() > 0,
                                p.getDescription()
                        )
                ).toList()
        );
    }
}

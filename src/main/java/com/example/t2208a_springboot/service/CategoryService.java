package com.example.t2208a_springboot.service;

import com.example.t2208a_springboot.entity.Category;
import com.example.t2208a_springboot.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category find(Long id){
        return categoryRepository.findById(id).get();
    }
}

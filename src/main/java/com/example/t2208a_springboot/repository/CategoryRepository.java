package com.example.t2208a_springboot.repository;

import com.example.t2208a_springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

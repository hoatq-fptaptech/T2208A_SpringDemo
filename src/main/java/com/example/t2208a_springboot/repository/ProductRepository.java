package com.example.t2208a_springboot.repository;

import com.example.t2208a_springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByName(String name); // find
    List<Product> findAllByNameContaining(String name); // search
    List<Product> findAllByNameContainingOrPrice(String name,Double price);
    // AdvanceSearch
    @Query("SELECT p from Product p "+
            "WHERE (:name is NULL OR p.name LIKE %:name%) "+
            "AND (:minPrice is NULL OR p.price >= :minPrice) "+
            "AND (:maxPrice is NULL OR p.price <= :maxPrice) "
    )
    List<Product> search(@Param("name") String name,
                         @Param("minPrice") Double minPrice,
                         @Param("maxPrice") Double maxPrice
                         );
}

package com.quiz2.quiz2.repo;

import java.util.List;

import com.quiz2.quiz2.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long>{
    
    List<Product> findByName(String name); 
}

package com.sample.sample.repository;

import java.util.List;

import com.sample.sample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    public Product findById(int id);
}
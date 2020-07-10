package com.sample.sample.service;

import java.util.List;

import com.sample.sample.entity.Product;
import com.sample.sample.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//このクラスは必要に応じて。
//現在は使ってない。
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> selectAll() {
        return productRepository.findAll();
    }
}
package com.example.demo.service;

import com.example.demo.model.dto.request.ProductRequest;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    @Transactional
    public Long create(ProductRequest req) {
        Product entity = new Product();
        entity.setName(req.getName());
        entity.setPrice(req.getPrice());
        Product product = productRepository.save(entity);
        return product.getId();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}

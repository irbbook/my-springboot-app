package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductRequest;
import com.example.demo.model.dto.response.CommonResponse;
import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<CommonResponse> create(@RequestBody ProductRequest req) {
        CommonResponse response = new CommonResponse();
        Long id = productService.create(req);
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage(HttpStatus.CREATED.getReasonPhrase() + " with ID: " + id);

        log.debug("Request :: {}", req);

        // Return 201 Created status with the response body
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<CommonResponse> getAll() {
        CommonResponse response = new CommonResponse();
        List<Product> productList = productService.findAll();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setData(productList);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductRequest;
import com.example.demo.model.dto.response.CommonResponse;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {
    int request = 0;

    @Autowired
    ProductService productService;

    @GetMapping("/hello-world")
    public ResponseEntity helloworkd(){
        CommonResponse response = new CommonResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Hello World");
        request +=1;
        log.debug("Request :: {}",request);

        return ResponseEntity.ok().body(response);
    }

}

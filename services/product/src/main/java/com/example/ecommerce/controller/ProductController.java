package com.example.ecommerce.controller;

import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

  @PostMapping
  public ProductResponse create(@RequestBody @Valid final ProductRequest request) {
    return null;
  }
}
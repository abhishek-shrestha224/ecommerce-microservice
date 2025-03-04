package com.example.ecommerce.controller;

import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.request.PurchaseRequest;
import com.example.ecommerce.response.ProductResponse;
import com.example.ecommerce.response.PurchaseResponse;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Integer create(@RequestBody @Valid final ProductRequest request) {
    log.info("POST::/product::{}", request);
    return productService.crete(request);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProductResponse> findAll() {
    log.info("GET::/product");
    return productService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse findById(@PathVariable("id") final Integer id) {
    log.info("GET::/product/{}", id);
    return productService.findById(id);
  }

  @PostMapping("/purchase")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public List<PurchaseResponse> purchase(@RequestBody @Valid final List<PurchaseRequest> order) {
    log.info("POST::/purchase::{}", order);
    return productService.purchase(order);
  }
}
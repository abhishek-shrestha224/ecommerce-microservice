package com.example.ecommerce.service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public Integer crete(ProductRequest req) {
    log.info("Creating product::{}", req);
    final var product = productMapper.toModel(req);
    log.info("Mapped product::{}", product);
    return productRepository.save(product).getId();
  }
}
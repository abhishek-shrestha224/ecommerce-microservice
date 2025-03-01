package com.example.ecommerce.service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.response.ProductResponse;
import com.example.ecommerce.utils.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

  public ProductResponse findById(Integer id) {
    log.info("Fetching product with ID::{}", id);
    final var product =
        productRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format("Product with ID %s does not exit.", id)));

    log.info("Found product::{}", product);
    return productMapper.toResponse(product);
  }

  public List<ProductResponse> findAll() {
    log.info("Fetching all products.");
    return productRepository.findAll().stream()
        .map(productMapper::toResponse)
        .collect(Collectors.toList());
  }
}
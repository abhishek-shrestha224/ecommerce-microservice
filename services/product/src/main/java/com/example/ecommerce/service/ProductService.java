package com.example.ecommerce.service;

import com.example.ecommerce.exception.PurchaseException;
import com.example.ecommerce.model.ProductModel;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.request.PurchaseRequest;
import com.example.ecommerce.response.ProductResponse;
import com.example.ecommerce.response.PurchaseResponse;
import com.example.ecommerce.utils.ProductMapper;
import com.example.ecommerce.utils.PurchaseMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final PurchaseMapper purchaseMapper;

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

  @Transactional
  public List<PurchaseResponse> purchase(List<PurchaseRequest> order) {
    log.info("Attempting to order for {}", order);
    List<Integer> orderProducts =
        order.stream().map(PurchaseRequest::productId).distinct().toList();

    log.info("Order Product IDs::{}", orderProducts);
    final var existingProducts = productRepository.findAllByIdInOrderById(orderProducts);

    log.info("Fetched Corresponding Products::{}", existingProducts);
    Map<Integer, ProductModel> productMap =
        existingProducts.stream().collect(Collectors.toMap(ProductModel::getId, p -> p));

    Map<Integer, String> errMsg = new HashMap<>();
    final var purchasedProducts = new ArrayList<PurchaseResponse>();
    List<ProductModel> updatedProducts = new ArrayList<>();

    order.forEach(
        item -> {
          final ProductModel product = productMap.get(item.productId());

          if (product == null) {
            errMsg.put(item.productId(), "Product with id " + item.productId() + " not found.");
            log.warn(errMsg.get(item.productId()));
          } else if (product.getQuantity() < item.quantity()) {
            errMsg.put(
                item.productId(),
                String.format("Not enough items with id %s in stock.", item.productId()));
            log.warn(errMsg.get(item.productId()));
          } else {
            log.info("Order details are OK");
            product.setQuantity(product.getQuantity() - item.quantity());
            log.info("Item left in stock::{}", product);
            updatedProducts.add(product);
            purchasedProducts.add(purchaseMapper.toResponse(product, item.quantity()));
          }
        });

    if (!updatedProducts.isEmpty()) {
      productRepository.saveAll(updatedProducts);
    }

    if (!errMsg.isEmpty()) {
      log.warn("Purchase failed due to insufficient stock or missing products: {}", errMsg);
      throw new PurchaseException(
          "Failed to complete purchase. Issues encountered: " + errMsg, errMsg);
    }

    log.info("Returning control back to controller with data::{}", purchasedProducts);
    return purchasedProducts;
  }
}
package com.example.ecommerce.utils;

import com.example.ecommerce.model.ProductModel;
import com.example.ecommerce.response.PurchaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurchaseMapper {

  public PurchaseResponse toResponse(ProductModel product, Integer quantity) {
    log.info("Product::{}, Quantity::{} -> PurchaseResponse", product, quantity);

    if (null == product) {
      log.warn("ProductModel produces NullPointerException.");
      return null;
    }
    if (null == quantity || quantity < 1) {
      log.warn("Quantity should be positive integer.");
      return null;
    }
    return PurchaseResponse.builder()
        .productId(product.getId())
        .productName(product.getName())
        .productPrice(product.getPrice())
        .quantity(quantity)
        .build();
  }
}
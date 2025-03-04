package com.example.ecommerce.request;

import jakarta.validation.constraints.Positive;

public record PurchaseRequest(@Positive Integer productId, @Positive Integer quantity) {
  @Override
  public String toString() {
    return String.format("ProductResponse[productId=%d, quantity=%d]", productId, quantity);
  }
}
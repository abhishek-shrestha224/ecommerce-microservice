package com.example.ecommerce.response;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
    Integer id, String name, Integer quantity, BigDecimal price, String categoryName) {
  @Override
  public String toString() {
    return String.format(
        "ProductResponse[id=%d, name='%s', quantity=%d, price=%.2f, categoryName='%s']",
        id, name, quantity, price, categoryName);
  }
}
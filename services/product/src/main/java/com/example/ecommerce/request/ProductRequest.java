package com.example.ecommerce.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequest(
    Integer id,
    @NotBlank String name,
    @Positive Integer quantity,
    @Positive BigDecimal price,
    @NotBlank String categoryName) {
  @Override
  public String toString() {
    return String.format(
        "ProductResponse[id=%d, name='%s', quantity=%d, price=%.2f, categoryName='%s']",
        id, name, quantity, price, categoryName);
  }
}
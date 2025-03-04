package com.example.ecommerce.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PurchaseResponse(
    Integer id, String productName, Integer quantity, BigDecimal price) {}
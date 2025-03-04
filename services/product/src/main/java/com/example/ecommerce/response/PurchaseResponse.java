package com.example.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import java.util.List;

@Builder
public record PurchaseResponse(
    Integer productId, String productName, BigDecimal productPrice, Integer quantity) {}
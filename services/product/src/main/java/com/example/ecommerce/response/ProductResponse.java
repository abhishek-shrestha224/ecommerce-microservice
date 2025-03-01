package com.example.ecommerce.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
    Integer id, String name, Integer quantity, BigDecimal price, String categoryName) {}
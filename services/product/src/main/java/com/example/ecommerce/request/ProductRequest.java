package com.example.ecommerce.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequest(
    Integer id,
    @NotBlank String name,
    @Positive double quantity,
    @Positive BigDecimal price,
    @NotBlank String categoryName) {}
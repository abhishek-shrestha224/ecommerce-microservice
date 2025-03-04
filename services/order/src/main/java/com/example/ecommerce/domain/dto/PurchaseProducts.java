package com.example.ecommerce.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public record PurchaseProducts(@NotNull Integer productId, @Positive Integer quantity) {}
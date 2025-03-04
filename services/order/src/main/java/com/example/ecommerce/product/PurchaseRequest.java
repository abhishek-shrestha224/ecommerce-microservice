package com.example.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public record PurchaseRequest(@NotNull Integer productId, @Positive Integer quantity) {}
package com.example.ecommerce.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record OrderItemRequest(
    Integer id, @NotNull Integer orderId, @NotNull @Valid PurchaseProducts products) {}
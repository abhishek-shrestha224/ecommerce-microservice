package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entity.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderRequest(
    Integer id,
    String ref,
    @Positive BigDecimal total,
    @NotNull PaymentMethod paymentMethod,
    @NotBlank String customerId,
    @NotEmpty @Valid List<PurchaseProducts> products) {}
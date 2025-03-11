package com.example.ecommerce.service.client.dto;

import com.example.ecommerce.domain.entity.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentRequest(
    Integer id,
    @NotNull @Positive BigDecimal amount,
    @NotBlank PaymentMethod paymentMethod,
    @NotNull @Positive Integer orderId,
    @NotBlank String orderRef,
    @Valid CustomerResponse customer) {}
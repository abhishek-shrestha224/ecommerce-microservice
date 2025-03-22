package com.example.ecommerce.ext;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentConfirmation(
    String orderRef,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerFName,
    String customerLName,
    String customerEmail) {}
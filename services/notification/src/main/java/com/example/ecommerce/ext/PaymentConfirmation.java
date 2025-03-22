package com.example.ecommerce.ext;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentConfirmation(
    String transactionNumber,
    String orderRef,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    CustomerInfo customerInfo) {}
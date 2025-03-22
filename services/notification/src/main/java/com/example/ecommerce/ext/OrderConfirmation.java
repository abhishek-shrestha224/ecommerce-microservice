package com.example.ecommerce.ext;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(
    String orderRef,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    CustomerInfo customer,
    List<Product> products) {}
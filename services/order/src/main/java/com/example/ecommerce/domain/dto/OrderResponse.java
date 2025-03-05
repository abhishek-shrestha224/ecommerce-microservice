package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entity.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderResponse(
    Integer id,
    String ref,
    BigDecimal total,
    PaymentMethod paymentMethod,
    String customerId,
    List<PurchaseProducts> products) {}
package com.example.ecommerce.service.kafka.dto;

import com.example.ecommerce.domain.entity.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentNotificationRequest(
    String orderRef,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerFName,
    String customerLName,
    String customerEmail) {}
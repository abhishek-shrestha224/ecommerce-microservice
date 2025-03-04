package com.example.ecommerce.service.kafka;

import com.example.ecommerce.domain.entity.PaymentMethod;
import com.example.ecommerce.service.client.dto.CustomerResponse;
import com.example.ecommerce.service.client.dto.PurchaseResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(
    String orderRef,
    BigDecimal total,
    PaymentMethod paymentMethod,
    CustomerResponse customer,
    List<PurchaseResponse> products) {}
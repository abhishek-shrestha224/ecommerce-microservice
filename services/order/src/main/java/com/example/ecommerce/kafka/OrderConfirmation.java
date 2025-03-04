package com.example.ecommerce.kafka;

import com.example.ecommerce.model.PaymentMethod;
import com.example.ecommerce.response.CustomerResponse;
import com.example.ecommerce.response.PurchaseResponse;
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
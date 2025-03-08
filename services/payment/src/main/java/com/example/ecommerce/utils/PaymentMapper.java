package com.example.ecommerce.utils;

import com.example.ecommerce.domain.dto.PaymentDto;
import com.example.ecommerce.domain.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

  public Payment toEntity(PaymentDto dto) {
    return Payment.builder()
        .id(dto.id())
        .orderId(dto.orderId())
        .paymentMethod(dto.paymentMethod())
        .amount(dto.amount())
        .build();
  }
}
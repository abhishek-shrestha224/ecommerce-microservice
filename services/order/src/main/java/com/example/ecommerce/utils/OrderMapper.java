package com.example.ecommerce.utils;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderMapper {
  public Order toEntity(OrderRequest request) {
  log.info("Mapping to OrderEntity from OrderRequest::{}", request);
    return Order.builder()
        .id(request.id())
        .customerId(request.customerId())
        .ref(request.ref())
        .total(request.total())
        .paymentMethod(request.paymentMethod())
        .build();
  }
}
package com.example.ecommerce.utils;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderLine;
import com.example.ecommerce.request.OrderLineRequest;
import com.example.ecommerce.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderLineMapper {
  public OrderLine toEntity(OrderLineRequest request) {
    log.info("Mapping to OrderLineEntity from OrderLineRequest::{}", request);
    return OrderLine.builder()
        .id(request.id())
        .order(Order.builder().id(request.orderId()).build())
        .productId(request.productId())
        .quantity(request.quantity())
        .build();
  }
}
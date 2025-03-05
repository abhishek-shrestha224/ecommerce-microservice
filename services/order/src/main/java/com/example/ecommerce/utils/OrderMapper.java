package com.example.ecommerce.utils;

import com.example.ecommerce.domain.dto.OrderResponse;
import com.example.ecommerce.domain.dto.PurchaseProducts;
import com.example.ecommerce.domain.entity.Order;
import com.example.ecommerce.domain.dto.OrderRequest;
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

  public OrderResponse toResponse(Order entity) {
    log.info("Mapping to OrderResponse from OrderEntity::{}", entity);
    return OrderResponse.builder()
        .id(entity.getId())
        .customerId(entity.getCustomerId())
        .ref(entity.getRef())
        .total(entity.getTotal())
        .paymentMethod(entity.getPaymentMethod())
        .products(
            entity.getOrderLines().stream()
                .map(
                    orderLine ->
                        new PurchaseProducts(orderLine.getProductId(), orderLine.getQuantity()))
                .toList())
        .build();
  }
}
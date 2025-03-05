package com.example.ecommerce.utils;

import com.example.ecommerce.domain.dto.PurchaseProducts;
import com.example.ecommerce.domain.entity.Order;
import com.example.ecommerce.domain.entity.OrderItem;
import com.example.ecommerce.domain.dto.OrderItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderItemMapper {
  public OrderItem toEntity(OrderItemRequest request) {
    log.info("Mapping to OrderItemEntity from OrderItemData::{}", request);
    return OrderItem.builder()
        .id(request.id())
        .order(Order.builder().id(request.orderId()).build())
        .productId(request.products().productId())
        .quantity(request.products().quantity())
        .build();
  }

  public PurchaseProducts toResponse(OrderItem orderItem) {
    log.info("Mapping to OrderItemData from OrderItemEntity::{}", orderItem);
    return PurchaseProducts.builder()
        .productId(orderItem.getProductId())
        .quantity(orderItem.getQuantity())
        .build();
  }
}
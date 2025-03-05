package com.example.ecommerce.service;

import com.example.ecommerce.domain.dto.PurchaseProducts;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.domain.dto.OrderItemRequest;
import com.example.ecommerce.service.client.dto.PurchaseResponse;
import com.example.ecommerce.utils.OrderItemMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemService {
  private final OrderItemRepository orderItemRepository;
  private final OrderItemMapper orderItemMapper;

  public void create(OrderItemRequest orderItemRequest) {
    log.info("Creating order line::{}", orderItemRequest);
    orderItemRepository.save(orderItemMapper.toEntity(orderItemRequest)).getId();
  }

  public List<PurchaseProducts> findAllByOrderId(Integer orderId) {
    log.info("Finding all order items in order::{}", orderId);
    return orderItemRepository.findAllByOrderId(orderId).stream()
        .map(orderItemMapper::toResponse)
        .toList();
  }

  public PurchaseProducts findByOrderIdAndProductId(Integer orderId, Integer productId) {
    log.info("Finding order item in order::{} and product::{}", orderId, productId);
    final var foundOrderItem =
        orderItemRepository
            .findByOrderIdAndProductId(orderId, productId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "Order item not found in order::%s and product::%s",
                            orderId, productId)));
    return orderItemMapper.toResponse(foundOrderItem);
  }
}
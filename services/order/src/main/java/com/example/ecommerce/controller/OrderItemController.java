package com.example.ecommerce.controller;

import com.example.ecommerce.domain.dto.PurchaseProducts;
import com.example.ecommerce.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order/{orderId}/item")
@RequiredArgsConstructor
public class OrderItemController {
  private final OrderItemService orderItemService;

  @GetMapping
  public List<PurchaseProducts> getOrderItems(@PathVariable("orderId") Integer orderId) {
    return orderItemService.findAllByOrderId(orderId);
  }
}
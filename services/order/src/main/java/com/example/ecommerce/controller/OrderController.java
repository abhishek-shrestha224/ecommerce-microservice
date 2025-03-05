package com.example.ecommerce.controller;

import com.example.ecommerce.domain.dto.OrderRequest;
import com.example.ecommerce.domain.dto.OrderResponse;
import com.example.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
  private final OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Integer order(@RequestBody @Valid final OrderRequest orderItems) {
    log.info("POST::/order::{}", orderItems);
    return orderService.create(orderItems);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<OrderResponse> findAll() {
    log.info("GET::/order");
    return orderService.findAll();
  }

  @GetMapping("/{orderId}")
  public OrderResponse findById(@PathVariable("orderId") final Integer orderId) {
    log.info("GET::/order/{}", orderId);
    return orderService.findById(orderId);
  }
}
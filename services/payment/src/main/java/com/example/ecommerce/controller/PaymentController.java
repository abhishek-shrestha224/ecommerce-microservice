package com.example.ecommerce.controller;

import com.example.ecommerce.domain.dto.PaymentDto;
import com.example.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
  private final PaymentService paymentService;

  @PostMapping
  public Integer createPayment(@RequestBody @Valid PaymentDto dto) {
    return paymentService.createPayment(dto);
  }
}
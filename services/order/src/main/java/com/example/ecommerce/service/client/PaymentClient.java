package com.example.ecommerce.service.client;

import com.example.ecommerce.service.client.dto.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "${application.config.payment-url}")
public interface PaymentClient {
  @PostMapping("/payment")
  Integer pay(@RequestBody @Valid PaymentRequest paymentRequest);
}
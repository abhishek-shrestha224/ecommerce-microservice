package com.example.ecommerce.service.client;

import com.example.ecommerce.service.client.dto.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer-service", url = "${application.config.customer-url}")
public interface CustomerClient {
  @GetMapping("/{id}")
  Optional<CustomerResponse> getCustomerById(@PathVariable("id") final String id);
}
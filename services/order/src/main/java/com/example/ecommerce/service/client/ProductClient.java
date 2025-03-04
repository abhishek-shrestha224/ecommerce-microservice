package com.example.ecommerce.service.client;

import com.example.ecommerce.domain.dto.PurchaseProducts;
import com.example.ecommerce.service.client.dto.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.product-url}")
public interface ProductClient {
  @PostMapping("/purchase")
  List<PurchaseResponse> purchase(@RequestBody List<PurchaseProducts> order);
}
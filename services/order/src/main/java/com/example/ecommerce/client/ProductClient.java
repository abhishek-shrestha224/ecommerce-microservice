package com.example.ecommerce.client;

import com.example.ecommerce.request.PurchaseRequest;
import com.example.ecommerce.response.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.product-url}")
public interface ProductClient {
  @PostMapping("/purchase")
  List<PurchaseResponse> purchase(@RequestBody List<PurchaseRequest> order);
}
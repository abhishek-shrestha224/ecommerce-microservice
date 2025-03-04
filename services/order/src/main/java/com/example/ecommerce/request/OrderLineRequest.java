package com.example.ecommerce.request;

import lombok.Builder;

@Builder
public record OrderLineRequest(Integer id, Integer orderId, Integer productId, Integer quantity) {}
package com.example.ecommerce.domain.dto;

import lombok.Builder;

@Builder
public record OrderLineRequest(Integer id, Integer orderId, Integer productId, Integer quantity) {}
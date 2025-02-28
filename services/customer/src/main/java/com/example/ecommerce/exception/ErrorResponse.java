package com.example.ecommerce.exception;

import lombok.Builder;

import java.util.Map;

@Builder
public record ErrorResponse(Map<String, String> err) {}
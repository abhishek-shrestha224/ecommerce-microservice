package com.example.ecommerce.service.client.dto;

import lombok.Builder;

@Builder
public record CustomerResponse(String id, String fName, String lName, String email) {}
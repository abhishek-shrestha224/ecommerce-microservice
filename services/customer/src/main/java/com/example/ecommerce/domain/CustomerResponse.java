package com.example.ecommerce.domain;

import lombok.Builder;

@Builder
public record CustomerResponse(
    String id, String fName, String lName, String email, Address address) {}
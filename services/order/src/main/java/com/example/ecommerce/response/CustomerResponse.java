package com.example.ecommerce.response;

import lombok.Builder;

@Builder
public record CustomerResponse(String id, String fName, String lName, String email) {}
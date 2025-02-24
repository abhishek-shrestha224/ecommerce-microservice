package com.example.ecommerce.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;

@Builder
public record CustomerRequest(
    @Null String id,
    @NotBlank String fName,
    @NotBlank String lName,
    @Email String email,
    @NotNull Address address) {}
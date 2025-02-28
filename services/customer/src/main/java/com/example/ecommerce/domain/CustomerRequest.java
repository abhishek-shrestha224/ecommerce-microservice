package com.example.ecommerce.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;

@Builder
public record CustomerRequest(
    @Null(message = "Id is assigned automatically.") String id,
    @NotBlank(message = "fName is required.") String fName,
    @NotBlank(message = "lName is required.") String lName,
    @NotNull(message = "Email is required.") @Email(message = "Email is not valid.") String email,
    @NotNull(message = "Address is required.") @Valid Address address) {}
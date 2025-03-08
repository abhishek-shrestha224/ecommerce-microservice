package com.example.ecommerce.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public record CustomerDetails(
    @NotBlank String fName, @NotBlank String lName, @NotBlank @Email String email) {}
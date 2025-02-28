package com.example.ecommerce.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Validated
public class Address {
  @NotBlank(message = "Street name/number is required.")
  private String street;

  @NotBlank(message = "House number is required.")
  private String houseNumber;

  @NotBlank(message = "Zip code is required.")
  private String zipCode;
}
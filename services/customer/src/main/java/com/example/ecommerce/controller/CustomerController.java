package com.example.ecommerce.controller;

import com.example.ecommerce.domain.CustomerRequest;
import com.example.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public String createCustomer(@RequestBody @Valid CustomerRequest customerData) {
    return "OK";
  }
}
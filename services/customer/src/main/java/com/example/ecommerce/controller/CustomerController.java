package com.example.ecommerce.controller;

import com.example.ecommerce.domain.CustomerRequest;
import com.example.ecommerce.domain.CustomerResponse;
import com.example.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String create(@RequestBody @Valid CustomerRequest req) {
    log.info("POST:: /customer :: {}", req);
    return customerService.create(req);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public boolean update(@RequestBody @Valid CustomerRequest req) {
    log.info("PUT:: /customer :: {}", req);
    return customerService.update(req);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CustomerResponse> findAll() {
    log.info("GET::/customer");
    return customerService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CustomerResponse findById(@PathVariable("id") final String id) {
    log.info("GET::/customer/{}", id);
    return customerService.findById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id") final String id) {
    log.info("DELETE::/customer/{}", id);
    customerService.deleteById(id);
  }
}
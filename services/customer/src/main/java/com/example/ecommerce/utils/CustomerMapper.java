package com.example.ecommerce.utils;

import com.example.ecommerce.domain.CustomerDocument;
import com.example.ecommerce.domain.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
  public CustomerDocument toDocument(CustomerRequest request) {
    return CustomerDocument.builder()
        .id(null)
        .fName(request.fName())
        .lName(request.lName())
        .email(request.email())
        .address(request.address())
        .build();
  }
}
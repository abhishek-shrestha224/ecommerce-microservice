package com.example.ecommerce.utils;

import com.example.ecommerce.domain.CustomerDocument;
import com.example.ecommerce.domain.CustomerRequest;
import com.example.ecommerce.domain.CustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerMapper {
  public CustomerDocument toDocument(CustomerRequest request) {
    log.info("CustomerRequest -> CustomerDocument, {}", request);

    if (null == request) {
      log.warn("CustomerRequest: NullPointerException");
      return null;
    }
    return CustomerDocument.builder()
        .id(null)
        .fName(request.fName())
        .lName(request.lName())
        .email(request.email())
        .address(request.address())
        .build();
  }

  public CustomerResponse toResponse(CustomerDocument document) {
    log.info("CustomerDocument -> CustomerReponse, {}", document);

    if (null == document) {
      log.warn("CustomerDocument: NullPointerException");
      return null;
    }
    return CustomerResponse.builder()
        .id(document.getId())
        .fName(document.getFName())
        .lName(document.getLName())
        .email(document.getEmail())
        .address(document.getAddress())
        .build();
  }
}
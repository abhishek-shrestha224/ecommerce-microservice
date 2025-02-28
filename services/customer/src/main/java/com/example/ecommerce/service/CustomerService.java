package com.example.ecommerce.service;

import com.example.ecommerce.domain.CustomerDocument;
import com.example.ecommerce.domain.CustomerRequest;
import com.example.ecommerce.domain.CustomerResponse;
import com.example.ecommerce.exception.CustomerNotFoundException;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.utils.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public String create(CustomerRequest req) {
    log.info("Creating Customer with data: {}", req);
    final CustomerDocument created = customerRepository.save(customerMapper.toDocument(req));
    log.info("Created Document: {}", created);
    return created.getId();
  }

  public boolean update(CustomerRequest req) {
    log.info("Updating the customer: {}", req);
    var customer =
        customerRepository
            .findById(req.id())
            .orElseThrow(
                () ->
                    new CustomerNotFoundException(
                        String.format(
                            "Cannot update customer. No customer with ID:: %s", req.id())));
    log.info("Customer found: {}", customer);

    customer.setFName(req.fName());
    customer.setLName(req.lName());
    customer.setEmail(req.email());
    customer.setAddress(req.address());

    log.info("Customer updated: {}", customer);
    return true;
  }

  public List<CustomerResponse> findAll() {
    log.info("Fetching all customers in db.");
    return customerRepository.findAll().stream()
        .map(customerMapper::toResponse)
        .collect(Collectors.toList());
  }

  public CustomerResponse findById(String id) {
    log.info("Fetching customer with id:: {}", id);
    return customerMapper.toResponse(
        customerRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new CustomerNotFoundException(
                        String.format("Cannot fetch customer with ID:: %s", id))));
  }

  public void deleteById(String id) {
    log.info("Deleting customer with id:: {}", id);
    customerRepository.deleteById(id);
  }
}
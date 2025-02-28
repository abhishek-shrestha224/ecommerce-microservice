package com.example.ecommerce.service;

import com.example.ecommerce.domain.CustomerDocument;
import com.example.ecommerce.domain.CustomerRequest;
import com.example.ecommerce.exception.CustomerNotFoundException;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.utils.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public String createCustomer(CustomerRequest req) {
    log.info("Creating Customer with data: {}", req);
    final CustomerDocument created = customerRepository.save(customerMapper.toDocument(req));
    log.info("Created Document: {}", created);
    return created.getId();
  }

  public boolean updateCustomer(CustomerRequest req) {
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
}
package com.example.ecommerce.repository;

import com.example.ecommerce.domain.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {}
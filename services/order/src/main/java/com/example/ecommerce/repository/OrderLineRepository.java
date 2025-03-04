package com.example.ecommerce.repository;

import com.example.ecommerce.domain.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {}
package com.example.ecommerce.service;

import com.example.ecommerce.repository.OrderLineRepository;
import com.example.ecommerce.request.OrderLineRequest;
import com.example.ecommerce.utils.OrderLineMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderLineService {
  private final OrderLineRepository orderLineRepository;
  private final OrderLineMapper orderLineMapper;

  public Integer create(OrderLineRequest orderLineRequest) {
    log.info("Creating order line::{}", orderLineRequest);
    return orderLineRepository.save(orderLineMapper.toEntity(orderLineRequest)).getId();
  }
}
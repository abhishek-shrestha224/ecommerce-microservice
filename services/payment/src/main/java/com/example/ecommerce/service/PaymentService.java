package com.example.ecommerce.service;

import com.example.ecommerce.domain.dto.PaymentDto;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.utils.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
  private PaymentRepository paymentRepository;
  private PaymentMapper paymentMapper;

  public Integer createPayment(PaymentDto dto) {
    return paymentRepository.save(paymentMapper.toEntity(dto)).getId();
  }
}
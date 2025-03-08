package com.example.ecommerce.service;

import com.example.ecommerce.domain.dto.PaymentDto;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.service.kafka.NotificationProducer;
import com.example.ecommerce.service.kafka.dto.PaymentConfirmation;
import com.example.ecommerce.utils.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final PaymentMapper paymentMapper;
  private final NotificationProducer notificationProducer;

  public Integer createPayment(PaymentDto dto) {
    final var created = paymentRepository.save(paymentMapper.toEntity(dto));
    notificationProducer.sendNotification(
        PaymentConfirmation.builder()
            .orderRef(dto.orderRef())
            .paymentMethod(dto.paymentMethod())
            .amount(dto.amount())
            .customerFName(dto.customer().fName())
            .customerLName(dto.customer().lName())
            .customerEmail(dto.customer().email())
            .build());
    return created.getId();
  }
}
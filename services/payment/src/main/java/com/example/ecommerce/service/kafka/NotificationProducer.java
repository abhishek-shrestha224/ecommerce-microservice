package com.example.ecommerce.service.kafka;

import com.example.ecommerce.service.kafka.dto.PaymentConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationProducer {
  private final KafkaTemplate<String, PaymentConfirmation> kafkaTemplate;

  public void sendNotification(PaymentConfirmation paymentConfirmation) {
    log.info("Sending notification with body::{}", paymentConfirmation);
    Message<PaymentConfirmation> message =
        MessageBuilder.withPayload(paymentConfirmation)
            .setHeader(KafkaHeaders.TOPIC, "payment_topic")
            .build();

    kafkaTemplate.send(message);
  }
}
package com.example.ecommerce.service.kafka;

import com.example.ecommerce.service.kafka.dto.PaymentNotificationRequest;
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
  private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;

  public void sendNotification(PaymentNotificationRequest request) {
    log.info("Sending notification with body::{}", request);
    Message<PaymentNotificationRequest> message =
        MessageBuilder.withPayload(request).setHeader(KafkaHeaders.TOPIC, "payment_topic").build();

    kafkaTemplate.send(message);
  }
}
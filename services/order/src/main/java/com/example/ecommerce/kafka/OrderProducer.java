package com.example.ecommerce.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

  public void sendOrderConfirmation(OrderConfirmation orderConfirmation) {
    log.info("Sending order confirmation::{}", orderConfirmation);
    Message<OrderConfirmation> message =
        MessageBuilder.withPayload(orderConfirmation)
            .setHeader(KafkaHeaders.TOPIC, "order-topic")
            .build();
  }
}
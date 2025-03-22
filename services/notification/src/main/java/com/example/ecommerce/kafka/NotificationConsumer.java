package com.example.ecommerce.kafka;

import com.example.ecommerce.ext.PaymentConfirmation;
import com.example.ecommerce.notification.repo.NotificationRepository;
import com.example.ecommerce.notification_sender.NotificationSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
  private final NotificationRepository notificationRepository;
  private final Map<String, NotificationSender> notificationSenders;

  //  private final NotificationService notificationService;

  @KafkaListener(topics = "payment-topic")
  public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) {
    log.info("Received Payment Confirmation::{}", paymentConfirmation);
    NotificationSender sender = notificationSenders.get("emailSender");
//    sender.sendNotification();
    // TODO: Save to db
    // TODO: Send email
  }
}
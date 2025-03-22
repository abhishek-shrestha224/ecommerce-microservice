package com.example.ecommerce.notification_sender;

import org.springframework.scheduling.annotation.Async;

public interface NotificationSender {

  @Async
  void sendNotification(String recipient, String message);
}
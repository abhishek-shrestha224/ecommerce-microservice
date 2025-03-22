package com.example.ecommerce.notification_sender;

import org.springframework.stereotype.Service;

@Service("smsSender")
public class SmsSender implements NotificationSender {
  @Override
  public void sendNotification(String recipient, String message) {
    System.out.println("📧 Sending SMS to " + recipient + ": " + message);
    // TODO: Implement actual email sending logic here
  }
}
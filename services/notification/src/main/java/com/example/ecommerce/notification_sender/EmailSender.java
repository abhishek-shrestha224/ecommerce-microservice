package com.example.ecommerce.notification_sender;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service("emailSender")
@RequiredArgsConstructor
public class EmailSender implements NotificationSender {

  private final JavaMailSender mailSender;
  private final SpringTemplateEngine templateEngine;
  @Override
  public void sendNotification(String recipient, String message) {
    System.out.println("📧 Sending Email to " + recipient + ": " + message);
    // TODO: Implement actual email sending logic here
  }
}
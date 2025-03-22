package com.example.ecommerce.notification.repo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class NotificationModel {
  @Id private String id;
  private NotificationType notificationType;
  private LocalDateTime notificationDateTime;

}
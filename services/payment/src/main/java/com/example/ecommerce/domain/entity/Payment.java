package com.example.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  private Integer orderId;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime created;

  @LastModifiedDate
  @Column(insertable = false)
  private LocalDateTime modified;
}
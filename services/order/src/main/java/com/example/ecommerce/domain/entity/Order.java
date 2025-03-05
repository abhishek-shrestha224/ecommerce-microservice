package com.example.ecommerce.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer_order")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "orderLines")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String ref;
  private BigDecimal total;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  private String customerId;

  @OneToMany(mappedBy = "order")
  @JsonManagedReference
  private List<OrderLine> orderLines;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime created;

  @LastModifiedDate
  @Column(insertable = false)
  private LocalDateTime modified;
}
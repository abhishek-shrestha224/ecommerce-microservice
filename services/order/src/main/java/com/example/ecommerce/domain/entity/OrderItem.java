package com.example.ecommerce.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_line")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "order")
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @ManyToOne
  @JoinColumn(name = "order_id")
  @JsonBackReference
  private Order order;

  private Integer productId;

  private Integer quantity;
}
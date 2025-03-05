package com.example.ecommerce.repository;

import com.example.ecommerce.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
  List<OrderItem> findAllByOrderId(Integer orderId);

  Optional<OrderItem> findByOrderIdAndProductId(Integer orderId, Integer productId);
}
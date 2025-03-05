package com.example.ecommerce.service;

import com.example.ecommerce.domain.dto.OrderResponse;
import com.example.ecommerce.domain.dto.PurchaseProducts;
import com.example.ecommerce.domain.entity.Order;
import com.example.ecommerce.service.client.CustomerClient;
import com.example.ecommerce.service.client.ProductClient;
import com.example.ecommerce.exception.BusinessException;
import com.example.ecommerce.service.client.dto.CustomerResponse;
import com.example.ecommerce.service.client.dto.PurchaseResponse;
import com.example.ecommerce.service.kafka.OrderConfirmation;
import com.example.ecommerce.service.kafka.OrderProducer;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.domain.dto.OrderLineRequest;
import com.example.ecommerce.domain.dto.OrderRequest;
import com.example.ecommerce.utils.OrderMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final CustomerClient customerClient;
  private final ProductClient productClient;
  private final OrderMapper orderMapper;
  private final OrderLineService orderLineService;
  private final OrderProducer orderProducer;

  public Integer create(OrderRequest orderRequest) {
    final var customer = getValidCustomer(orderRequest.customerId());

    final var purchasedProducts = productClient.purchase(orderRequest.products());

    var order = saveOrder(orderRequest);
    createOrderLines(order, orderRequest.products());

    sendOrderConfirmation(orderRequest, customer, purchasedProducts);

    return order.getId();
  }

  public List<OrderResponse> findAll() {
    return orderRepository.findAll().stream().map(orderMapper::toResponse).toList();
  }

  public OrderResponse findById(Integer id) {
    return orderRepository
        .findById(id)
        .map(orderMapper::toResponse)
        .orElseThrow(
            () -> new EntityNotFoundException(String.format("Order not found with id::%d", id)));
  }

  //  ! Utils
  private CustomerResponse getValidCustomer(String customerId) {
    return Optional.ofNullable(customerClient.getCustomerById(customerId))
        .orElseThrow(
            () ->
                new BusinessException(
                    "Cannot create order. No customer found with id::" + customerId));
  }

  private Order saveOrder(OrderRequest orderRequest) {
    return orderRepository.save(orderMapper.toEntity(orderRequest));
  }

  private void createOrderLines(Order order, List<PurchaseProducts> products) {
    products.forEach(
        item ->
            orderLineService.create(
                new OrderLineRequest(null, order.getId(), item.productId(), item.quantity())));
  }

  private void sendOrderConfirmation(
      OrderRequest orderRequest,
      CustomerResponse customer,
      List<PurchaseResponse> purchasedProducts) {
    orderProducer.sendOrderConfirmation(
        new OrderConfirmation(
            orderRequest.ref(),
            orderRequest.total(),
            orderRequest.paymentMethod(),
            customer,
            purchasedProducts));
  }
}
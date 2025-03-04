package com.example.ecommerce.service;

import com.example.ecommerce.service.client.CustomerClient;
import com.example.ecommerce.service.client.ProductClient;
import com.example.ecommerce.exception.BusinessException;
import com.example.ecommerce.service.kafka.OrderConfirmation;
import com.example.ecommerce.service.kafka.OrderProducer;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.domain.dto.OrderLineRequest;
import com.example.ecommerce.domain.dto.OrderRequest;
import com.example.ecommerce.utils.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    final var customer =
        customerClient
            .getCustomerById(orderRequest.customerId())
            .orElseThrow(
                () ->
                    new BusinessException(
                        String.format(
                            "Cannot create order. No customer found with id::%s",
                            orderRequest.customerId())));

    final var purchasedProducts = productClient.purchase(orderRequest.products());

    var order = orderRepository.save(orderMapper.toEntity(orderRequest));

    orderRequest
        .products()
        .forEach(
            item ->
                orderLineService.create(
                    new OrderLineRequest(null, order.getId(), item.productId(), item.quantity())));

    orderProducer.sendOrderConfirmation(
        new OrderConfirmation(
            orderRequest.ref(),
            orderRequest.total(),
            orderRequest.paymentMethod(),
            customer,
            purchasedProducts));

    return order.getId();
  }
}
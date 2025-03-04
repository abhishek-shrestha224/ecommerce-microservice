package com.example.ecommerce.utils;

import com.example.ecommerce.model.CategoryModel;
import com.example.ecommerce.model.ProductModel;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductMapper {

  public ProductModel toModel(ProductRequest req) {
    log.info("ProductRequest -> ProductModel::{}", req);
    return ProductModel.builder()
        .id(req.id())
        .name(req.name())
        .quantity(req.quantity())
        .price(req.price())
        .category(CategoryModel.builder().name(req.categoryName()).build())
        .build();
  }

  public ProductResponse toResponse(ProductModel model) {
    log.info("ProductModel -> ProductResponse::{}", model);

    return ProductResponse.builder()
        .id(model.getId())
        .name(model.getName())
        .quantity(model.getQuantity())
        .price(model.getPrice())
        .categoryName(model.getCategory().getName())
        .build();
  }

}
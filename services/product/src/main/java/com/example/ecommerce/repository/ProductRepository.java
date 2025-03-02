package com.example.ecommerce.repository;

import com.example.ecommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
  List<ProductModel> findAllByIdInOrderById(List<Integer> productIds);
}
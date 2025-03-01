package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
  private List<ProductModel> products;
}
package com.example.ecommerce.ext;

import java.math.BigDecimal;

public record Product(Integer id, String productName, Integer quantity, BigDecimal price) {}
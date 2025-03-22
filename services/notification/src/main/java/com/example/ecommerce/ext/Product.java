package com.example.ecommerce.ext;

import java.math.BigDecimal;

public record Product(String id, String name, BigDecimal price, Integer quantity) {}
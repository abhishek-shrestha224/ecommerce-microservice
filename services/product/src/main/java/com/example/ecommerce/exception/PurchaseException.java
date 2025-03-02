package com.example.ecommerce.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class PurchaseException extends RuntimeException {

  private final Map<Integer, String> errMsg;

  public PurchaseException(String msg, Map<Integer, String> errMsg) {
    super(msg);
    this.errMsg = errMsg;
  }
}
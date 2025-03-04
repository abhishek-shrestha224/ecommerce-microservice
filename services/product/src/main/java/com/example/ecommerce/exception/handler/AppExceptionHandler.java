package com.example.ecommerce.exception.handler;

import com.example.ecommerce.exception.PurchaseException;
import com.example.ecommerce.response.PurchaseResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
  @ExceptionHandler(PurchaseException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, String> handle(PurchaseException ex) {
    final var errMsg = new HashMap<String, String>();
    errMsg.put("message", ex.getMessage());
    errMsg.put("description", ex.getErrMsg().toString());
    return errMsg;
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handle(EntityNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, String> handle(MethodArgumentNotValidException ex) {
    final var err = new HashMap<String, String>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            e -> {
              final var fieldName = ((FieldError) e).getField();
              final var errMsg = e.getDefaultMessage();
              err.put(fieldName, errMsg);
            });
    return err;
  }
}
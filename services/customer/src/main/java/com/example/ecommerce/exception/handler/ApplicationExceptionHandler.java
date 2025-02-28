package com.example.ecommerce.exception.handler;

import com.example.ecommerce.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
  @ExceptionHandler(CustomerNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handle(CustomerNotFoundException ex) {
    return ex.getMsg();
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
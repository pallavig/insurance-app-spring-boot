package com.thoughtworks.insuranceappspringboot.controller;

import com.thoughtworks.insuranceappspringboot.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoAdvice {

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<Object> handleException() {
        return ResponseEntity.notFound().build();
    }
}

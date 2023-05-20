package com.sda.javaremoteee21spring.controller.rest;

import com.sda.javaremoteee21spring.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CarRestAdvisor {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleNotFoundCarException(CarNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}

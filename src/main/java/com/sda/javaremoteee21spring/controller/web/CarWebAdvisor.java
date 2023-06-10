package com.sda.javaremoteee21spring.controller.web;

import com.sda.javaremoteee21spring.exception.CarNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarWebAdvisor {

    @ExceptionHandler(CarNotFoundException.class)
    public String notFoundPage() {
        return "errors/not-found";
    }
}

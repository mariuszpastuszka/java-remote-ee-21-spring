package com.sda.javaremoteee21spring.controller.rest;

import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        log.info("getting all car");
        return carService.findAllCars();
    }

    // /cars/1
    // /cars/3
    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id) {
        log.info("Getting car by id: [{}]", id);
        return carService.findCarById(id);
    }
}

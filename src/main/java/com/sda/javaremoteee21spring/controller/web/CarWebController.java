package com.sda.javaremoteee21spring.controller.web;

import com.sda.javaremoteee21spring.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/web")
public class CarWebController {

    private static final String CARS = "cars";

    private static final String NAME = "name";

    private static final String SURNAME = "surname";

    private final CarService carService;

    public CarWebController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"/home-page", ""})
    public String homePage(Model data,
                           @RequestParam(value = NAME, defaultValue = "Mariusz") String name,
                           @RequestParam(value = SURNAME, defaultValue = "P.") String surname) {
        log.info("home page");

        data.addAttribute(NAME, name);
        data.addAttribute(SURNAME, surname);
        return "home-page";
    }

    @GetMapping("/cars")
    public String allCars(Model data) {
        log.info("All cars at html page");

        var allCars = carService.findAllCars();
        data.addAttribute(CARS, allCars);
        return "all-cars";
    }
}

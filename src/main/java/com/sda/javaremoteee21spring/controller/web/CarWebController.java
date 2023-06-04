package com.sda.javaremoteee21spring.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/web")
public class CarWebController {

    @GetMapping({"/home-page", ""})
    public String homePage() {
        log.info("home page");

        return "home-page";
    }
}

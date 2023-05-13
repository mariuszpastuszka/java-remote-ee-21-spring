package com.sda.javaremoteee21spring.controller.rest;

import com.sda.javaremoteee21spring.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyFirstController {

    @GetMapping("/name")
    public String showMeMyName() {
        return "mariusz";
    }

    @GetMapping("/me")
    public Person justMe() {
        return new Person("mariusz", "p.", 18);
    }

    @GetMapping("me-and-friend")
    public List<Person> meAndFriend() {
        List<Person> persons = new ArrayList<>();
        // persons.add(...);
        // persons.add(...);
        return List.of(
                new Person("mariusz", "p.", 18),
                new Person("john", "k.", 25)
        );
    }
}

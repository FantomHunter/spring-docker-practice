package com.codehunter.springdockerpractice.controllers;

import com.codehunter.springdockerpractice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GreetingController {
    private final UserRepository userRepository;


    @GetMapping("/greeting")
    public String greeting() {
        return "Hello docker v2: build fat jar from src";
    }

    @GetMapping("/greeting-from-db")
    public String greetingFromDb(@RequestParam String id) {

        if (id != null){
            Long idAsLong = Long.parseLong(id);
            return userRepository.findById(idAsLong).map(userDAO -> userDAO.getName()).orElse("id not found");
        }
        return "id is required";

    }
}

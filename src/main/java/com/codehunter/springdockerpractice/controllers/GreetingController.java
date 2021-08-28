package com.codehunter.springdockerpractice.controllers;

import com.codehunter.springdockerpractice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class GreetingController {
    private final UserRepository userRepository;

    @GetMapping("/greeting")
    public GreetingResponse greeting() {
        log.info("Say Greeting");
        return new GreetingResponse("Hello docker v2: build fat jar from src");
    }

    @GetMapping("/greeting-from-db")
    public GreetingResponse greetingFromDb(@RequestParam String id) {
        if (id != null) {
            log.info("greetingFromDb for user "+ id);
            Long idAsLong = Long.parseLong(id);
            return userRepository.findById(idAsLong)
                    .map(userDAO -> new GreetingResponse(userDAO.getName()))
                    .orElse(new GreetingResponse("id not found"));
        }
        return new GreetingResponse("id is required");
    }

    @Data
    @AllArgsConstructor
    public class GreetingResponse {
        private String message;
    }
}

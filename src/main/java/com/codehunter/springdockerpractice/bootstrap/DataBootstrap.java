package com.codehunter.springdockerpractice.bootstrap;

import com.codehunter.springdockerpractice.entites.UserDAO;
import com.codehunter.springdockerpractice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final UserRepository userRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Start init data...");
        userRepository.saveAll(List.of(
                UserDAO.builder().id(1L).name("User1").build(),
                UserDAO.builder().id(2L).name("User2").build(),
                UserDAO.builder().id(3L).name("User3").build(),
                UserDAO.builder().id(4L).name("User4").build(),
                UserDAO.builder().id(5L).name("User5").build()
        ));
        log.info("End init data.");

    }
}

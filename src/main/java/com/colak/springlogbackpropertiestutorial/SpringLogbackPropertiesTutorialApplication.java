package com.colak.springlogbackpropertiestutorial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringLogbackPropertiesTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLogbackPropertiesTutorialApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> log.info("password=a");
    }
}

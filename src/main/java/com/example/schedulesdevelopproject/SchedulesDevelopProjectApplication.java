package com.example.schedulesdevelopproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulesDevelopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulesDevelopProjectApplication.class, args);
    }

}

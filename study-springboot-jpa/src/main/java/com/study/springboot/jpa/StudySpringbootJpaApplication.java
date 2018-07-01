package com.study.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudySpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringbootJpaApplication.class, args);
    }
}

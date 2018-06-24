package com.study.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.springboot.dao")
public class StudySpringbootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringbootServerApplication.class, args);
    }
}

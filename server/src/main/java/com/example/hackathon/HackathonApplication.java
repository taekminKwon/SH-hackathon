package com.example.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

}

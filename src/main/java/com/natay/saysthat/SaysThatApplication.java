package com.natay.saysthat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class SaysThatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaysThatApplication.class, args);
    }

}

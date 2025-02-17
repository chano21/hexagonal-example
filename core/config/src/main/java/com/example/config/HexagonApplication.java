package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.*"})
@SpringBootApplication
public class HexagonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonApplication.class, args);
    }

}

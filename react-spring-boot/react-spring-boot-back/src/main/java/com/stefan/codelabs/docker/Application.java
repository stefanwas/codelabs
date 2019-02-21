package com.stefan.codelabs.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stefan"})
public class Application {

//        @Resource
//        private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}

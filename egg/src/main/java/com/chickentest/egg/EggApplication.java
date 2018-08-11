package com.chickentest.egg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EggApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggApplication.class, args);
    }
}

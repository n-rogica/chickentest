package com.chickentest.chicken;

import com.chickentest.chicken.model.Chicken;
import com.chickentest.chicken.repository.ChickenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class ChickenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChickenApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData (ChickenRepository chickenRepositoryy) {

        Chicken chicken1 = new Chicken(1L);
        Chicken chicken2 = new Chicken(2L);
        Chicken chicken3 = new Chicken(3L);

        return args -> {
            chickenRepositoryy.save(chicken1);
            chickenRepositoryy.save(chicken2);
            chickenRepositoryy.save(chicken3);
        };
    }
}

package com.chickentest.farm;

import com.chickentest.farm.model.Farm;
import com.chickentest.farm.repository.FarmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class FarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData (FarmRepository farmRepository) {

        Farm farm1 = new Farm("farm 1");
        Farm farm2 = new Farm("farm 2");
        Farm farm3 = new Farm("farm 3");

        farm1.addChickenId(1L);
        farm1.addChickenId(2L);
        farm2.addChickenId(3L);
        return args -> {
            farmRepository.save(farm1);
            farmRepository.save(farm2);
            farmRepository.save(farm3);
        };
    }
}

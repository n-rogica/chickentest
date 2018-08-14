package com.chickentest.farmservice;

import com.chickentest.farmservice.clientservice.ClientFarmService;
import controller.ClientFarmController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class FarmserviceApplication {

    public static final String SERVICE_URL = "http://FARM-SERVICE";

    public static void main(String[] args) {
        SpringApplication.run(FarmserviceApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ClientFarmService clientFarmService() {
        return new ClientFarmService(SERVICE_URL);
    }

    @Bean
    public ClientFarmController clientFarmController() {
        return new ClientFarmController(clientFarmService());
    }
}

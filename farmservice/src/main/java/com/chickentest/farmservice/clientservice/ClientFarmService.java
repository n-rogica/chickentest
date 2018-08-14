package com.chickentest.farmservice.clientservice;

import com.chickentest.farmservice.dto.FarmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientFarmService {

    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public ClientFarmService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
    }

    public FarmDTO farm(String farmId) {
        FarmDTO farmDTO = restTemplate.getForObject(serviceUrl + "/getFarm/{farmId}", FarmDTO.class, farmId);
        return farmDTO;
    }
}

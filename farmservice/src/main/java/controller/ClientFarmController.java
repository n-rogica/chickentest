package controller;


import com.chickentest.farmservice.clientservice.ClientFarmService;
import com.chickentest.farmservice.dto.FarmDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class ClientFarmController {

    protected ClientFarmService clientFarmService;

    public ClientFarmController(ClientFarmService clientFarmService) {
        this.clientFarmService = clientFarmService;
    }

    @RequestMapping("/getFarm/{farmId}")
    public FarmDTO getFarmDTO(Model model, @PathVariable("farmId") String farmId) {
        FarmDTO farmDTO = clientFarmService.farm(farmId);
        return farmDTO;
    }

}

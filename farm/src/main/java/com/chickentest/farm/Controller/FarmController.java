package com.chickentest.farm.Controller;

import com.chickentest.farm.repository.FarmRepository;
import com.chickentest.farm.model.Farm;
import com.sun.net.httpserver.Authenticator;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FarmController {

    @Autowired
    FarmRepository farmRepository;

    @RequestMapping(path = "/countChickens/{id}", method = RequestMethod.GET)
    public int getChikensForId(@PathVariable("id") long farmId) {
       Farm farm = farmRepository.getOne(farmId);

       if ( farm != null) {
           return farm.chickenCount();
       }

       return -1;
    }

    @RequestMapping(path = "/newFarm", method = RequestMethod.PUT )
    public Object newFarm() {
        farmRepository.save(new Farm());
        return this.createResponseEntity("Ok", "Farm creado", HttpStatus.CREATED);
    }

    @RequestMapping(path = "getFarm/{farmId}", method = RequestMethod.GET)
    public Object getFarm(@PathVariable("farmId") Long farmId) {
        if (farmRepository.existsById(farmId)) {
            Farm requestFarm = farmRepository.getOne(farmId);
            return requestFarm.getFarmDTO();
        }

        return this.createResponseEntity("Error", "Farm id incorrecto", HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(path = "/getChickens/{farmId}", method = RequestMethod.GET)
    public Object getChickenIds(@PathVariable("farmId") Long farmId) {

        if (farmRepository.existsById(farmId)) {
            Farm requestFarm = farmRepository.getOne(farmId);
            return requestFarm.getChickensIds();
        }
        return this.createResponseEntity("Error", "Farm id incorrecto", HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<Object> createResponseEntity(String respuesta, String valor, HttpStatus httpStatus) {
        Map<String,Object> responseMap = new LinkedHashMap<>();
        responseMap.put(respuesta, valor);
        return new ResponseEntity<>(responseMap, httpStatus);
    }
}

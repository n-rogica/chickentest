package com.chickentest.chicken.controller;

import com.chickentest.chicken.model.Chicken;
import com.chickentest.chicken.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChickenController {

    @Autowired
    ChickenRepository chickenRepository;

    @RequestMapping(path = "/getFarmId/{chickenId}", method = RequestMethod.GET)
    public Long getFarmId(@PathVariable("chickenId") long chickenId) {
        Chicken chicken = chickenRepository.getOne(chickenId);

        if (chicken != null) {
            return chicken.getFarmId();
        }
        return -1L;
    }

    @RequestMapping(path = "/getChicken/{id}", method = RequestMethod.GET)
    public Object getChicken(@PathVariable("id") long chickenId) {
        if (chickenRepository.existsById(chickenId)) {
            Chicken requestChicken = chickenRepository.getOne(chickenId);
            return requestChicken.getChickenDTO();
        }

        return this.createResponseEntity("Error", "Chicken id incorrecto", HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<Object> createResponseEntity(String respuesta, String valor, HttpStatus httpStatus) {
        Map<String,Object> responseMap = new LinkedHashMap<>();
        responseMap.put(respuesta, valor);
        return new ResponseEntity<>(responseMap, httpStatus);
    }

}

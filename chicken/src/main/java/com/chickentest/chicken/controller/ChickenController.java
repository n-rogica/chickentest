package com.chickentest.chicken.controller;

import com.chickentest.chicken.model.Chicken;
import com.chickentest.chicken.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}

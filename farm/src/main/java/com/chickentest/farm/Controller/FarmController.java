package com.chickentest.farm.Controller;

import com.chickentest.farm.repository.FarmRepository;
import com.chickentest.farm.model.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
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
}

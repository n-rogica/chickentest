package com.chickentest.chicken.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Chicken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long farmId;

    @ElementCollection
    List<Long> eggIds = new ArrayList<>();


    public Chicken(){}

    public Chicken(Long farmId) {
        this.farmId = farmId;
    }

    public Long getFarmId() {
        return this.farmId;
    }

    public void addEgg(Long eggId) {
        this.eggIds.add(eggId);
    }

    public int countEggs() {
        return this.eggIds.size();
    }

    public Map<String,Object> getChickenDTO() {
        Map<String,Object> chickenDTO = new LinkedHashMap<>();
        chickenDTO.put("chicken id", this.id);
        chickenDTO.put("farm id", this.farmId);
        chickenDTO.put("eggs", this.eggIds);
        return chickenDTO;
    }
}

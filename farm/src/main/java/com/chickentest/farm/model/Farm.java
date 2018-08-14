package com.chickentest.farm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    @ElementCollection
    List<Long> chickensIds = new ArrayList<>();

    public Farm() {}

    public void addChickenId(Long chickenId) {
        this.chickensIds.add(chickenId);
    }

    public int chickenCount() {
        return this.chickensIds.size();
    }

    public List<Long> getChickensIds() {
        return this.chickensIds;
    }

    public Map<String,Object> getFarmDTO() {
        LinkedHashMap<String,Object> farmDTO = new LinkedHashMap<>();
        farmDTO.put("farmId", this.id);
        farmDTO.put("chickensIds", this.chickensIds);
        return farmDTO;
    }
}

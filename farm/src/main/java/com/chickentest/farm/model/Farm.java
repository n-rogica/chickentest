package com.chickentest.farm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    private String nombre;

    @ElementCollection
    List<Long> chickensId = new ArrayList<>();

    public Farm() {}

    public Farm(String nombre) {
        this.nombre = nombre;
    }

    public void addChickenId(Long chickenId) {
        this.chickensId.add(chickenId);
    }

    public int chickenCount() {
        return this.chickensId.size();
    }
}

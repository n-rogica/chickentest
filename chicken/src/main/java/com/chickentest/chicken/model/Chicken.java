package com.chickentest.chicken.model;

import javax.persistence.*;

@Entity
public class Chicken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long farmId;


    public Chicken(){}

    public Chicken(Long farmId) {
        this.farmId = farmId;
    }

    public Long getFarmId() {
        return this.farmId;
    }
}

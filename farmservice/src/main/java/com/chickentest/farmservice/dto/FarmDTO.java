package com.chickentest.farmservice.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("FarmDTO")
public class FarmDTO {

    protected Long farmId;
    protected List<Long> chickensIds;

    public FarmDTO() {}

    public FarmDTO(Long farmIds) {
        this.farmId = farmId;
        this.chickensIds = new ArrayList<>();
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public void setChickensIds(List<Long> chickensIds) {
        this.chickensIds = chickensIds;
    }

    public Long getFarmId() {
        return this.farmId;
    }

    public List<Long> getChickensIds() {
        return this.chickensIds;
    }

}

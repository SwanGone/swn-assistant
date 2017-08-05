package com.swnerrata.swnassstant.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class SectorSystem extends AbstractEntity {

    private String name = "";

    private String rowNumber;

    private String colNumber;

    @OneToMany
    @JoinColumn(name = "sector_system_uid")
    private List<Planet> planetsInSystem = new ArrayList<>();

    public SectorSystem() { }

    public SectorSystem(String rowNumber, String colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getColNumber() {
        return colNumber;
    }

    public void setColNumber(String colNumber) {
        this.colNumber = colNumber;
    }

    public List<Planet> getPlanetsInSystem() {
        return planetsInSystem;
    }

    public void setPlanetsInSystem(List<Planet> planetsInSystem) {
        this.planetsInSystem = planetsInSystem;
    }
}

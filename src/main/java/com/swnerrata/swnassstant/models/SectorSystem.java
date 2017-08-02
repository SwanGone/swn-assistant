package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class SectorSystem extends AbstractEntity {

    private String name;

    private int rowNumber;

    private int colNumber;

    @OneToMany
    @JoinColumn(name = "sector_system_uid")
    private List<Planet> planetsInSystem = new ArrayList<>();

    SectorSystem() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public List<Planet> getPlanetsInSystem() {
        return planetsInSystem;
    }

    public void setWorldsInSystem(List<Planet> planetsInSystem) {
        this.planetsInSystem = planetsInSystem;
    }
}

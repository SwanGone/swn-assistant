package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class Planet extends AbstractEntity {

    private String name;

    private String atmosphere;

    private String biosphere;

    private String temperature;

    private int population;

    private int techLevel;

    private ArrayList<String> tags;

    private String cultureNotes;

    @ManyToOne
    private SectorSystem sectorSystem;

    public Planet() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    public String getBiosphere() {
        return biosphere;
    }

    public void setBiosphere(String biosphere) {
        this.biosphere = biosphere;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getCultureNotes() {
        return cultureNotes;
    }

    public void setCultureNotes(String cultureNotes) {
        this.cultureNotes = cultureNotes;
    }

    public SectorSystem getSectorSystem() {
        return sectorSystem;
    }

    public void setSectorSystem(SectorSystem sectorSystem) {
        this.sectorSystem = sectorSystem;
    }
}

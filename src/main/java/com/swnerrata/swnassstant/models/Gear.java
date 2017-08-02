package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class Gear extends AbstractEntity {

    private String name;

    private String gearType;

    private String description;

    Gear() { }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getGearType() { return gearType; }

    public void setGearType(String gearType) { this.gearType = gearType; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}

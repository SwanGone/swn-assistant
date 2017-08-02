package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class Skill extends AbstractEntity {

    private String name;

    Skill() { }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}

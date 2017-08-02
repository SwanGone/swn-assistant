package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class PsychicDiscipline extends AbstractEntity {

    private String name;

    private String school;

    private int level;

    private String description;

    public PsychicDiscipline() { }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSchool() { return school; }

    public void setSchool(String school) { this.school = school; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

}

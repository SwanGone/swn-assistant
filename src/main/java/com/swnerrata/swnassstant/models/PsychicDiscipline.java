package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;

/**
 * Created by seanburk on 8/1/17.
 */
@Entity
public class PsychicDiscipline extends AbstractEntity {

    private String name;

    private String school;

    private String description;

    PsychicDiscipline() { }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSchool() { return school; }

    public void setSchool(String school) { this.school = school; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

}

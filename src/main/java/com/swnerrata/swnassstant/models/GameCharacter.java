package com.swnerrata.swnassstant.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by seanburk on 7/28/17.
 */
@Entity
public class GameCharacter extends AbstractEntity {

    @NotNull
    @Size(min=1)
    private String name;

    private int level;

    private String characterClass;

    private int strength;

    private int intelligence;

    private int dexterity;

    private int wisdom;

    private int constitution;

    private int charisma;

    private int hitPoints;

    private int psiPoints;

    private int currentHitPoints;

    private int currentPsiPoints;

    private HashMap<String, Integer> skills; //TODO change skills to its own class

    private HashMap<String, Integer> gear; //TODO change gear to its own class

    private ArrayList<String> psychicDisciplines;

    private ArrayList<String> masteredDisciplines;


    //Constructors

    public GameCharacter() { }

    public GameCharacter(String name) { this.name = name; }


    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public String getCharacterClass() { return characterClass; }

    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }

    public int getStrength() { return strength; }

    public void setStrength(int strength) { this.strength = strength; }

    public int getIntelligence() { return intelligence; }

    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    public int getDexterity() { return dexterity; }

    public void setDexterity(int dexterity) { this.dexterity = dexterity; }

    public int getWisdom() { return wisdom; }

    public void setWisdom(int wisdom) { this.wisdom = wisdom; }

    public int getConstitution() { return constitution; }

    public void setConstitution(int constitution) { this.constitution = constitution; }

    public int getCharisma() { return charisma; }

    public void setCharisma(int charisma) { this.charisma = charisma; }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getPsiPoints() { return psiPoints; }

    public void setPsiPoints(int psiPoints) { this.psiPoints = psiPoints; }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) { this.currentHitPoints = currentHitPoints; }

    public int getCurrentPsiPoints() {
        return currentPsiPoints;
    }

    public void setCurrentPsiPoints(int currentPsiPoints) { this.currentPsiPoints = currentPsiPoints; }

    public HashMap<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Integer> skills) {
        this.skills = skills;
    }

    public HashMap<String, Integer> getGear() { return gear; }

    public void setGear(HashMap<String, Integer> gear) {
        this.gear = gear;
    }

    public ArrayList<String> getPsychicDisciplines() { return psychicDisciplines; }

    public void setPsychicDisciplines(ArrayList<String> psychicDisciplines) { this.psychicDisciplines = psychicDisciplines; }

    public ArrayList<String> getMasteredDisciplines() {
        return masteredDisciplines;
    }

    public void setMasteredDisciplines(ArrayList<String> masteredDisciplines) { this.masteredDisciplines = masteredDisciplines; }

}

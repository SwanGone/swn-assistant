package com.swnerrata.swnassstant.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by seanburk on 7/28/17.
 */
public class Character extends AbstractEntity {

    private String name;

    private HashMap<String, Integer> level;

    private HashMap<String, Integer> abilityScore; //TODO change abilityScore to its own class

    private int hitPoints;

    private int psiPoints;

    private int currentHitPoints;

    private int currentPsiPoints;

    private HashMap<String, Integer> skills; //TODO change skills to its own class

    private HashMap<String, Integer> gear; //TODO change gear to its own class

    private ArrayList<String> psychicDisciplines;

    private ArrayList<String> masteredDisciplines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getLevel() {
        return level;
    }

    public void setLevel(HashMap<String, Integer> level) {
        this.level = level;
    }

    public HashMap<String, Integer> getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(HashMap<String, Integer> abilityScore) {
        this.abilityScore = abilityScore;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getPsiPoints() {
        return psiPoints;
    }

    public void setPsiPoints(int psiPoints) {
        this.psiPoints = psiPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getCurrentPsiPoints() {
        return currentPsiPoints;
    }

    public void setCurrentPsiPoints(int currentPsiPoints) {
        this.currentPsiPoints = currentPsiPoints;
    }

    public HashMap<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Integer> skills) {
        this.skills = skills;
    }

    public HashMap<String, Integer> getGear() {
        return gear;
    }

    public void setGear(HashMap<String, Integer> gear) {
        this.gear = gear;
    }

    public ArrayList<String> getPsychicDisciplines() {
        return psychicDisciplines;
    }

    public void setPsychicDisciplines(ArrayList<String> psychicDisciplines) {
        this.psychicDisciplines = psychicDisciplines;
    }

    public ArrayList<String> getMasteredDisciplines() {
        return masteredDisciplines;
    }

    public void setMasteredDisciplines(ArrayList<String> masteredDisciplines) {
        this.masteredDisciplines = masteredDisciplines;
    }
}

package com.example.dndcharapp;

public enum ClassInfo {
    Artificer("Constitution", "Intelligence", "d8", 8),
    Barbarian("Strength", "Constitution", "d12", 12),
    Bard("Dexterity", "Charisma", "d8", 8),
    Cleric("Wisdom", "Charisma", "d8", 8),
    Druid("Intelligence", "Wisdom", "d8", 8),
    Fighter("Strength", "Constitution", "d10", 10),
    Monk("Dexterity", "Wisdom", "d8", 8),
    Paladin("Wisdom", "Charisma", "d10", 10),
    Ranger("Strength", "Dexterity", "d10", 10),
    Rogue("Dexterity", "Intelligence", "d8", 8),
    Sorcerer("Constitution", "Charisma", "d6", 6),
    Warlock("Wisdom", "Charisma", "d8", 8),
    Wizard("Intelligence", "Wisdom", "d6", 6);

    private final String savingThrowOne;
    private final String savingThrowTwo;
    private final String hitDice;
    private final int hitPoints;

    private ClassInfo(String savingThrowOne, String savingThrowTwo, String hitDice, int hitPoints){
        this.savingThrowOne = savingThrowOne;
        this.savingThrowTwo = savingThrowTwo;
        this.hitDice = hitDice;
        this.hitPoints = hitPoints;
    }

    public String getClassStOne(){
        return savingThrowOne;
    }

    public String getClassStTwo(){
        return savingThrowTwo;
    }

    public String getHitDice(){
        return hitDice;
    }

    public int getHitPoints() { return hitPoints; }
}

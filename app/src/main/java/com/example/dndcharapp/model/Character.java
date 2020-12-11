package com.example.dndcharapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "characters")
public class Character implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int cId;

    @ColumnInfo(name = "cName")
    private String cName;

    @ColumnInfo(name = "cClass")
    private String cClass;

    @ColumnInfo(name = "cRace")
    private String cRace;

    @ColumnInfo(name = "cAlignment")
    private String cAlignment;

    @ColumnInfo(name = "cBackground")
    private String cBackground;

    @ColumnInfo(name = "cLevel", defaultValue = "1")
    private int cLevel;

    @ColumnInfo(name = "cXp", defaultValue = "0")
    private int cXp;

    @ColumnInfo(name = "cProficiency ", defaultValue = "0")
    private int cProficiency;

    @ColumnInfo(name = "cSavingThrowOne")
    private String cSavingThrowOne;

    @ColumnInfo(name = "cSavingThrowTwo")
    private String cSavingThrowTwo;

    @ColumnInfo(name = "cHitDice")
    private String cHitDice;

    @ColumnInfo(name = "cHp", defaultValue = "8")
    private int cHp;

    @ColumnInfo(name = "cAc", defaultValue = "10")
    private int cAc;

    @ColumnInfo(name = "cSpeed", defaultValue = "30")
    private int cSpeed;

    @ColumnInfo(name = "cStrength", defaultValue = "10")
    private int cStrength;

    @ColumnInfo(name = "cDexterity", defaultValue = "10")
    private int cDexterity;

    @ColumnInfo(name = "cConstitution", defaultValue = "10")
    private int cConstitution;

    @ColumnInfo(name = "cIntelligence", defaultValue = "10")
    private int cIntelligence;

    @ColumnInfo(name = "cWisdom", defaultValue = "10")
    private int cWisdom;

    @ColumnInfo(name = "cCharisma", defaultValue = "10")
    private int cCharisma;

    @ColumnInfo(name = "cAcrobatics", defaultValue = "0")
    private int cAcrobatics;

    @ColumnInfo(name = "cAnimalHandling", defaultValue = "0")
    private int cAnimalHandling;

    @ColumnInfo(name = "cArcana", defaultValue = "0")
    private int cArcana;

    @ColumnInfo(name = "cAthletics", defaultValue = "0")
    private int cAthletics;

    @ColumnInfo(name = "cDeception", defaultValue = "0")
    private int cDeception;

    @ColumnInfo(name = "cHistory", defaultValue = "0")
    private int cHistory;

    @ColumnInfo(name = "cInsight", defaultValue = "0")
    private int cInsight;

    @ColumnInfo(name = "cIntimidation", defaultValue = "0")
    private int cIntimidation;

    @ColumnInfo(name = "cInvestigation", defaultValue = "0")
    private int cInvestigation;

    @ColumnInfo(name = "cMedicine", defaultValue = "0")
    private int cMedicine;

    @ColumnInfo(name = "cNature", defaultValue = "0")
    private int cNature;

    @ColumnInfo(name = "cPerception", defaultValue = "0")
    private int cPerception;

    @ColumnInfo(name = "cPerformance", defaultValue = "0")
    private int cPerformance;

    @ColumnInfo(name = "cPersuasion", defaultValue = "0")
    private int cPersuasion;

    @ColumnInfo(name = "cReligion", defaultValue = "0")
    private int cReligion;

    @ColumnInfo(name = "cSleightOfHand", defaultValue = "0")
    private int cSleightOfHand;

    @ColumnInfo(name = "cStealth", defaultValue = "0")
    private int cStealth;

    @ColumnInfo(name = "cSurvival", defaultValue = "0")
    private int cSurvival;

    @ColumnInfo(name = "cPw", defaultValue = "10")
    private int cPw;


    public Character(String cName, String cClass, String cRace, String cAlignment,
                     String cBackground, int cLevel, int cXp, int cProficiency,
                     String cSavingThrowOne, String cSavingThrowTwo, String cHitDice,
                     int cHp, int cAc, int cSpeed, int cStrength, int cDexterity,
                     int cConstitution, int cIntelligence, int cWisdom, int cCharisma,
                     int cAcrobatics, int cAnimalHandling, int cArcana, int cAthletics,
                     int cDeception, int cHistory, int cInsight, int cIntimidation,
                     int cInvestigation, int cMedicine, int cNature, int cPerception,
                     int cPerformance, int cPersuasion, int cReligion, int cSleightOfHand,
                     int cStealth, int cSurvival, int cPw) {
        this.cName = cName;
        this.cClass = cClass;
        this.cRace = cRace;
        this.cAlignment = cAlignment;
        this.cBackground = cBackground;
        this.cLevel = cLevel;
        this.cXp = cXp;
        this.cProficiency = cProficiency;
        this.cSavingThrowOne = cSavingThrowOne;
        this.cSavingThrowTwo = cSavingThrowTwo;
        this.cHitDice = cHitDice;
        this.cHp = cHp;
        this.cAc = cAc;
        this.cSpeed = cSpeed;
        this.cStrength = cStrength;
        this.cDexterity = cDexterity;
        this.cConstitution = cConstitution;
        this.cIntelligence = cIntelligence;
        this.cWisdom = cWisdom;
        this.cCharisma = cCharisma;
        this.cAcrobatics = cAcrobatics;
        this.cAnimalHandling = cAnimalHandling;
        this.cArcana = cArcana;
        this.cAthletics = cAthletics;
        this.cDeception = cDeception;
        this.cHistory = cHistory;
        this.cInsight = cInsight;
        this.cIntimidation = cIntimidation;
        this.cInvestigation = cInvestigation;
        this.cMedicine = cMedicine;
        this.cNature = cNature;
        this.cPerception = cPerception;
        this.cPerformance = cPerformance;
        this.cPersuasion = cPersuasion;
        this.cReligion = cReligion;
        this.cSleightOfHand = cSleightOfHand;
        this.cStealth = cStealth;
        this.cSurvival = cSurvival;
        this.cPw = cPw;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public int getCId() {
        return cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCClass() {
        return cClass;
    }

    public void setCClass(String cClass) {
        this.cClass = cClass;
    }

    public String getCRace() {
        return cRace;
    }

    public void setCRace(String cRace) {
        this.cRace = cRace;
    }

    public String getCAlignment() {
        return cAlignment;
    }

    public void setCAlignment(String cAlignment) {
        this.cAlignment = cAlignment;
    }

    public String getCBackground() {
        return cBackground;
    }

    public void setCBackground(String cBackground) {
        this.cBackground = cBackground;
    }

    public int getCLevel() {
        return cLevel;
    }

    public void setCLevel(int cLevel) {
        this.cLevel = cLevel;
    }

    public int getCXp() {
        return cXp;
    }

    public void setCXp(int cXp) {
        this.cXp = cXp;
    }

    public int getCProficiency() {
        return cProficiency;
    }

    public void setCProficiency(int cProficiency) {
        this.cProficiency = cProficiency;
    }

    public String getCSavingThrowOne() {
        return cSavingThrowOne;
    }

    public void setCSavingThrowOne(String cSavingThrowOne) {
        this.cSavingThrowOne = cSavingThrowOne;
    }

    public String getCSavingThrowTwo() {
        return cSavingThrowTwo;
    }

    public void setCSavingThrowTwo(String cSavingThrowTwo) {
        this.cSavingThrowTwo = cSavingThrowTwo;
    }

    public String getCHitDice() {
        return cHitDice;
    }

    public void setCHitDice(String cHitDice) {
        this.cHitDice = cHitDice;
    }

    public int getCHp() {
        return cHp;
    }

    public void setCHp(int cHp) {
        this.cHp = cHp;
    }

    public int getCAc() {
        return cAc;
    }

    public void setCAc(int cAc) {
        this.cAc = cAc;
    }

    public int getCSpeed() {
        return cSpeed;
    }

    public void setCSpeed(int cSpeed) {
        this.cSpeed = cSpeed;
    }

    public int getCStrength() {
        return cStrength;
    }

    public void setCStrength(int cStrength) {
        this.cStrength = cStrength;
    }

    public int getCDexterity() {
        return cDexterity;
    }

    public void setCDexterity(int cDexterity) {
        this.cDexterity = cDexterity;
    }

    public int getCConstitution() {
        return cConstitution;
    }

    public void setCConstitution(int cConstitution) {
        this.cConstitution = cConstitution;
    }

    public int getCIntelligence() {
        return cIntelligence;
    }

    public void setCIntelligence(int cIntelligence) {
        this.cIntelligence = cIntelligence;
    }

    public int getCWisdom() {
        return cWisdom;
    }

    public void setCWisdom(int cWisdom) {
        this.cWisdom = cWisdom;
    }

    public int getCCharisma() {
        return cCharisma;
    }

    public void setCCharisma(int cCharisma) {
        this.cCharisma = cCharisma;
    }

    public int getCAcrobatics() {
        return cAcrobatics;
    }

    public void setCAcrobatics(int cAcrobatics) {
        this.cAcrobatics = cAcrobatics;
    }

    public int getCAnimalHandling() {
        return cAnimalHandling;
    }

    public void setCAnimalHandling(int cAnimalHandling) {
        this.cAnimalHandling = cAnimalHandling;
    }

    public int getCArcana() {
        return cArcana;
    }

    public void setCArcana(int cArcana) {
        this.cArcana = cArcana;
    }

    public int getCAthletics() {
        return cAthletics;
    }

    public void setCAthletics(int cAthletics) {
        this.cAthletics = cAthletics;
    }

    public int getCDeception() {
        return cDeception;
    }

    public void setCDeception(int cDeception) {
        this.cDeception = cDeception;
    }

    public int getCHistory() {
        return cHistory;
    }

    public void setCHistory(int cHistory) {
        this.cHistory = cHistory;
    }

    public int getCInsight() {
        return cInsight;
    }

    public void setCInsight(int cInsight) {
        this.cInsight = cInsight;
    }

    public int getCIntimidation() {
        return cIntimidation;
    }

    public void setCIntimidation(int cIntimidation) {
        this.cIntimidation = cIntimidation;
    }

    public int getCInvestigation() {
        return cInvestigation;
    }

    public void setCInvestigation(int cInvestigation) {
        this.cInvestigation = cInvestigation;
    }

    public int getCMedicine() {
        return cMedicine;
    }

    public void setCMedicine(int cMedicine) {
        this.cMedicine = cMedicine;
    }

    public int getCNature() {
        return cNature;
    }

    public void setCNature(int cNature) {
        this.cNature = cNature;
    }

    public int getCPerception() {
        return cPerception;
    }

    public void setCPerception(int cPerception) {
        this.cPerception = cPerception;
    }

    public int getCPerformance() {
        return cPerformance;
    }

    public void setCPerformance(int cPerformance) {
        this.cPerformance = cPerformance;
    }

    public int getCPersuasion() {
        return cPersuasion;
    }

    public void setCPersuasion(int cPersuasion) {
        this.cPersuasion = cPersuasion;
    }

    public int getCReligion() {
        return cReligion;
    }

    public void setCReligion(int cReligion) {
        this.cReligion = cReligion;
    }

    public int getCSleightOfHand() {
        return cSleightOfHand;
    }

    public void setCSleightOfHand(int cSleightOfHand) {
        this.cSleightOfHand = cSleightOfHand;
    }

    public int getCStealth() {
        return cStealth;
    }

    public void setCStealth(int cStealth) {
        this.cStealth = cStealth;
    }

    public int getCSurvival() {
        return cSurvival;
    }

    public void setCSurvival(int cSurvival) {
        this.cSurvival = cSurvival;
    }

    public int getCPw() {
        return cPw;
    }

    public void setCPw(int cPw) {
        this.cPw = cPw;
    }

    @Ignore
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @Ignore
    public Character(Parcel in){
        this.cId = in.readInt();
        this.cName = in.readString();
        this.cClass = in.readString();
        this.cRace = in.readString();
        this.cAlignment = in.readString();
        this.cBackground = in.readString();
        this.cLevel = in.readInt();
        this.cXp = in.readInt();
        this.cProficiency = in.readInt();
        this.cSavingThrowOne = in.readString();
        this.cSavingThrowTwo = in.readString();
        this.cHitDice = in.readString();
        this.cHp = in.readInt();
        this.cAc = in.readInt();
        this.cSpeed = in.readInt();
        this.cStrength = in.readInt();
        this.cDexterity = in.readInt();
        this.cConstitution = in.readInt();
        this.cIntelligence = in.readInt();
        this.cWisdom = in.readInt();
        this.cCharisma = in.readInt();
        this.cAcrobatics = in.readInt();
        this.cAnimalHandling = in.readInt();
        this.cArcana = in.readInt();
        this.cAthletics = in.readInt();
        this.cDeception = in.readInt();
        this.cHistory = in.readInt();
        this.cInsight = in.readInt();
        this.cIntimidation = in.readInt();
        this.cInvestigation = in.readInt();
        this.cMedicine = in.readInt();
        this.cNature = in.readInt();
        this.cPerception = in.readInt();
        this.cPerformance = in.readInt();
        this.cPersuasion = in.readInt();
        this.cReligion = in.readInt();
        this.cSleightOfHand = in.readInt();
        this.cStealth = in.readInt();
        this.cSurvival = in.readInt();
        this.cPw = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cId);
        dest.writeString(this.cName);
        dest.writeString(this.cClass);
        dest.writeString(this.cRace);
        dest.writeString(this.cAlignment);
        dest.writeString(this.cBackground);
        dest.writeInt(this.cLevel);
        dest.writeInt(this.cXp);
        dest.writeInt(this.cProficiency);
        dest.writeString(this.cSavingThrowOne);
        dest.writeString(this.cSavingThrowTwo);
        dest.writeString(this.cHitDice);
        dest.writeInt(this.cHp);
        dest.writeInt(this.cAc);
        dest.writeInt(this.cSpeed);
        dest.writeInt(this.cStrength);
        dest.writeInt(this.cDexterity);
        dest.writeInt(this.cConstitution);
        dest.writeInt(this.cIntelligence);
        dest.writeInt(this.cWisdom);
        dest.writeInt(this.cCharisma);
        dest.writeInt(this.cAcrobatics);
        dest.writeInt(this.cAnimalHandling);
        dest.writeInt(this.cArcana);
        dest.writeInt(this.cAthletics);
        dest.writeInt(this.cDeception);
        dest.writeInt(this.cHistory);
        dest.writeInt(this.cInsight);
        dest.writeInt(this.cIntimidation);
        dest.writeInt(this.cInvestigation);
        dest.writeInt(this.cMedicine);
        dest.writeInt(this.cNature);
        dest.writeInt(this.cPerception);
        dest.writeInt(this.cPerformance);
        dest.writeInt(this.cPersuasion);
        dest.writeInt(this.cReligion);
        dest.writeInt(this.cSleightOfHand);
        dest.writeInt(this.cStealth);
        dest.writeInt(this.cSurvival);
        dest.writeInt(this.cPw);
    }
}

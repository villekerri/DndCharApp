package com.example.dndcharapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "spells", foreignKeys = @ForeignKey(entity = Character.class,
        parentColumns = "cId",
        childColumns = "cId",
        onDelete = CASCADE))
public class Spell {
    @PrimaryKey(autoGenerate = true)
    private int spellId;

    @ColumnInfo(name = "spellName")
    private String spellName;

    @ColumnInfo(name = "spellLevel")
    private int spellLevel;

    @ColumnInfo(name = "spellNote")
    private String spellNote;

    @ColumnInfo(name = "cId")
    private int cId;

    public Spell(String spellName, int spellLevel, String spellNote, int cId) {
        this.spellName = spellName;
        this.spellLevel = spellLevel;
        this.spellNote = spellNote;
        this.cId = cId;
    }

    public void setSpellId(int spellId) {
        this.spellId = spellId;
    }

    public int getSpellId() {
        return spellId;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getSpellNote() {
        return spellNote;
    }

    public void setSpellNote(String spellNote) {
        this.spellNote = spellNote;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }
}

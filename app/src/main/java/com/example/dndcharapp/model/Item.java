package com.example.dndcharapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "items", foreignKeys = @ForeignKey(entity = Character.class,
        parentColumns = "cId",
        childColumns = "cId",
        onDelete = CASCADE))
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int itemId;

    @ColumnInfo(name = "itemName")
    private String itemName;

    @ColumnInfo(name = "itemNote")
    private String itemNote;

    @ColumnInfo(name = "cId")
    private int cId;

    public Item(String itemName, String itemNote, int cId) {
        this.itemName = itemName;
        this.itemNote = itemNote;
        this.cId = cId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }
}

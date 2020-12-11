package com.example.dndcharapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "notes", foreignKeys = @ForeignKey(entity = Character.class,
        parentColumns = "cId",
        childColumns = "cId",
        onDelete = CASCADE))
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int noteId;

    @ColumnInfo(name = "noteTitle")
    private String noteName;

    @ColumnInfo(name = "noteText")
    private String noteText;

    @ColumnInfo(name = "cId")
    private int cId;

    public Note(String noteName, String noteText, int cId) {
        this.noteName = noteName;
        this.noteText = noteText;
        this.cId = cId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }
}

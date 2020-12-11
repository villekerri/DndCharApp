package com.example.dndcharapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();

    @Query("SELECT * FROM notes ORDER BY noteTitle ASC")
    LiveData<List<Note>> getNotesAlphabetized();

    @Query("SELECT * FROM notes WHERE cId=:cId")
    LiveData<List<Note>> getNotesBycId(final int cId);
}

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
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCharacter(Character character);

    @Update
    void updateCharacter(Character character);

    @Delete
    void deleteCharacter(Character character);

    @Query("DELETE FROM characters")
    void deleteAllCharacters();

    @Query("SELECT * FROM characters ORDER BY cName ASC")
    LiveData<List<Character>> getCharactersAlphabetized();

    @Query("SELECT * FROM characters WHERE cId=:cId LIMIT 1")
    LiveData<Character> getCharacterBycId(int cId);
}

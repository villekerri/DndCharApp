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
public interface SpellDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSpell(Spell spell);

    @Update
    void updateSpell(Spell spell);

    @Delete
    void deleteSpell(Spell spell);

    @Query("DELETE FROM spells")
    void deleteAllSpells();

    @Query("SELECT * FROM spells ORDER BY spellName ASC")
    LiveData<List<Spell>> getSpellsAlphabetized();

    @Query("SELECT * FROM spells WHERE cId=:cId")
    LiveData<List<Spell>> getSpellsBycId(final int cId);
}

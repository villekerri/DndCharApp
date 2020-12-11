package com.example.dndcharapp;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.CharacterDao;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.ItemDao;
import com.example.dndcharapp.model.Note;
import com.example.dndcharapp.model.NoteDao;
import com.example.dndcharapp.model.Spell;
import com.example.dndcharapp.model.SpellDao;

import java.util.List;

public class DndReposity {
    private CharacterDao characterDao;
    private ItemDao itemDao;
    private NoteDao noteDao;
    private SpellDao spellDao;

    private LiveData<List<Character>> allCharacters;

    DndReposity(Application application) {
        DndRoomDb db = DndRoomDb.getDatabase(application);
        characterDao = db.characterDao();
        itemDao = db.itemDao();
        noteDao = db.noteDao();
        spellDao = db.spellDao();
        allCharacters = characterDao.getCharactersAlphabetized();
    }

    LiveData<List<Character>> getAllCharacters(){ return allCharacters; }
    LiveData<Character> getCharacter(int cId){ return characterDao.getCharacterBycId(cId); }
    LiveData<List<Item>> getAllItemsOfCharacter(int cId){ return itemDao.getItemsBycId(cId); }
    LiveData<List<Note>> getAllNotesOfCharacter(int cId){ return noteDao.getNotesBycId(cId); }
    LiveData<List<Spell>> getAllSpellsOfCharacter(int cId){ return spellDao.getSpellsBycId(cId); }

    void insertCharacter(Character character){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            characterDao.insertCharacter(character);
        });
    }

    void updateCharacter(Character character){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            characterDao.updateCharacter(character);
        });
    }

    void deleteCharacter(Character character){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            characterDao.deleteCharacter(character);
        });
    }

    void insertNote(Note note){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            noteDao.insertNote(note);
        });
    }

    void updateNote(Note note){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            noteDao.updateNote(note);
        });
    }

    void deleteNote(Note note){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            noteDao.deleteNote(note);
        });
    }


    void insertItem(Item item){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            itemDao.insertItem(item);
        });
    }

    void updateItem(Item item){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            itemDao.updateItem(item);
        });
    }

    void deleteItem(Item item){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            itemDao.deleteItem(item);
        });
    }


    void insertSpell(Spell spell){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            spellDao.insertSpell(spell);
        });
    }

    void updateSpell(Spell spell){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            spellDao.updateSpell(spell);
        });
    }

    void deleteSpell(Spell spell){
        DndRoomDb.databaseWriteExecutor.execute(() -> {
            spellDao.deleteSpell(spell);
        });
    }
}

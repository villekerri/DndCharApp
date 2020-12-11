package com.example.dndcharapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.Note;
import com.example.dndcharapp.model.Spell;

import java.util.List;

public class DndViewModel extends AndroidViewModel {
    private DndReposity mReposity;

    private final LiveData<List<Character>> allCharacters;
    private MutableLiveData<Character> choice = new MutableLiveData<>();
    private MutableLiveData<Note> chosenNote = new MutableLiveData<>();
    private MutableLiveData<Item> chosenItem = new MutableLiveData<>();
    private MutableLiveData<Spell> chosenSpell = new MutableLiveData<>();

    public DndViewModel(Application application){
        super(application);
        mReposity = new DndReposity(application);
        allCharacters = mReposity.getAllCharacters();
    }


    public void setChoice(Character character){ this.choice.setValue(character);}

    public LiveData<Character> getChoice(){ return choice; }

    public void setChosenNote(Note note){ this.chosenNote.setValue(note);}

    public LiveData<Note> getChosenNote(){ return chosenNote; }

    public void setChosenItem(Item item){ this.chosenItem.setValue(item);}

    public LiveData<Item> getChosenItem(){ return chosenItem; }

    public void setChosenSpell(Spell spell){ this.chosenSpell.setValue(spell);}

    public LiveData<Spell> getChosenSpell(){ return chosenSpell; }

    //character
    LiveData<List<Character>> getAllCharacters(){ return allCharacters; }

    public void insertCharacter(Character character){ mReposity.insertCharacter(character); }

    public void updateCharacter(Character character){
        mReposity.updateCharacter(character);
    }

    public void deleteCharacter(Character character) { mReposity.deleteCharacter(character);}

    public LiveData<Character> getCharacter(int cId){
        return mReposity.getCharacter(cId);
    }

    //note
    public void insertNote(Note note){ mReposity.insertNote(note); }

    public void updateNote(Note note){
        mReposity.updateNote(note);
    }

    public void deleteNote(Note note) { mReposity.deleteNote(note);}

    public LiveData<List<Note>> getAllNotesOfCharacter(int cId) {
        return mReposity.getAllNotesOfCharacter(cId);
    }

    //item
    public void insertItem(Item item){ mReposity.insertItem(item); }

    public void updateItem(Item item){
        mReposity.updateItem(item);
    }

    public void deleteItem(Item item) { mReposity.deleteItem(item);}

    public LiveData<List<Item>> getAllItemsOfCharacter(int cId) {
        return mReposity.getAllItemsOfCharacter(cId);
    }

    //spell
    public void insertSpell(Spell spell){ mReposity.insertSpell(spell); }

    public void updateSpell(Spell spell){
        mReposity.updateSpell(spell);
    }

    public void deleteSpell(Spell spell) { mReposity.deleteSpell(spell);}

    public LiveData<List<Spell>> getAllSpellsOfCharacter(int cId) {
        return mReposity.getAllSpellsOfCharacter(cId);
    }
}

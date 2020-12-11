package com.example.dndcharapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dndcharapp.model.Spell;

public class FragmentEditSpell extends Fragment {
    private DndViewModel dndViewModel;
    private Spell spellToEdit;
    private int spellLvl = 0;
    private Button btSaveEditedSpell;
    private Button btBackToAllSpells;
    private EditText etSpellName;
    private EditText etSpellNote;
    private EditText etSpellLvl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dndViewModel = new ViewModelProvider(getActivity()).get(DndViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_edit_spell, container, false);
        btSaveEditedSpell = (Button)v.findViewById(R.id.btSaveSpell);
        btBackToAllSpells = (Button)v.findViewById(R.id.btBackToAllSpells);
        etSpellName = (EditText)v.findViewById(R.id.etSpellName);
        etSpellNote = (EditText)v.findViewById(R.id.etSpellNote);
        etSpellLvl = (EditText)v.findViewById(R.id.etEditSpellLvl);
        //spell = ((NotesActivity)getActivity()).getSpell();

        dndViewModel.getChosenSpell().observe(getViewLifecycleOwner(), spell -> {
            spellToEdit = spell;
            etSpellName.setText(spellToEdit.getSpellName());
            etSpellNote.setText(spellToEdit.getSpellNote());
            etSpellLvl.setText(String.valueOf(spellToEdit.getSpellLevel()));
        });

        btSaveEditedSpell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spellToEdit.setSpellName(etSpellName.getText().toString());
                spellToEdit.setSpellNote(etSpellNote.getText().toString());
                spellToEdit.setSpellLevel(Integer.parseInt(etSpellLvl.getText().toString()));
                dndViewModel.updateSpell(spellToEdit);
                ((NotesActivity)getActivity()).setViewPager(6);
            }
        });
        btBackToAllSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(6);
            }
        });

        return v;
    }
}

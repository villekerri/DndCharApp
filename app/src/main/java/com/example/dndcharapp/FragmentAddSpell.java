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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.Spell;

public class FragmentAddSpell extends Fragment {
    private DndViewModel dndViewModel;
    private Character player;
    private Button btAddSpell;
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
        View v = inflater.inflate(R.layout.fragment_add_spell, container, false);
        btAddSpell = (Button)v.findViewById(R.id.btSaveSpell);
        btBackToAllSpells = (Button)v.findViewById(R.id.btBackToAllSpells);
        etSpellName = (EditText)v.findViewById(R.id.etSpellName);
        etSpellNote = (EditText)v.findViewById(R.id.etSpellNote);
        etSpellLvl = (EditText)v.findViewById(R.id.etNewSpellLvl);

        player = ((NotesActivity)getActivity()).getPlayer();

        btAddSpell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spell newSpell = new Spell(etSpellName.getText().toString(),
                        Integer.parseInt(etSpellLvl.getText().toString()),
                        etSpellNote.getText().toString(),
                        player.getCId());
                dndViewModel.insertSpell(newSpell);
                etSpellName.setText("");
                etSpellLvl.setText("");
                etSpellNote.setText("");
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

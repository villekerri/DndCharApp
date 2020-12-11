package com.example.dndcharapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.Spell;

public class FragmentAllSpells extends Fragment {
    private Character player;
    private Button btAddSpell;
    private Button btNavToItems;
    private Button btNavToNotes;
    private DndViewModel dndViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dndViewModel = new ViewModelProvider(getActivity()).get(DndViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_spells, container, false);
        btAddSpell = (Button)v.findViewById(R.id.btAddSpell);
        btNavToItems = (Button)v.findViewById(R.id.btNavItemsFromSpells);
        btNavToNotes = (Button)v.findViewById(R.id.btNavNotesFromSpells);
        player = ((NotesActivity)getActivity()).getPlayer();

        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
        final SpellListAdapter adapter = new SpellListAdapter(
                new SpellListAdapter.SpellDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dndViewModel.getAllSpellsOfCharacter(player.getCId()).observe(getViewLifecycleOwner(), spells -> {
            if(spells.size() > 0){
                adapter.submitList(spells);
            } else {
                Toast.makeText(getActivity(), "No spells.", Toast.LENGTH_SHORT).show();
                adapter.submitList(spells);
            }
        });


        btAddSpell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((NotesActivity)getActivity()).setViewPager(7);
            }
        });

        btNavToNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(0);
            }
        });

        btNavToItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(3);
            }
        });


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Spell spell = (Spell) valinta.getTag();
                dndViewModel.setChosenSpell(spell);
                ((NotesActivity)getActivity()).setViewPager(8);
            }

            @Override
            public void onLongClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Spell spell = (Spell) valinta.getTag();
                String poistettava = spell.getSpellName();


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("Remove spell");
                builder.setMessage("Are you sure you want to remove the spell: " + poistettava);
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dndViewModel.deleteSpell(spell);
                                Toast.makeText(getActivity(), poistettava + " removed.",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Removing " + poistettava + " cancelled.",
                                Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }));

        return v;
    }
}
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
import com.example.dndcharapp.model.Note;

public class FragmentAllNotes extends Fragment {
    private Character player;
    private Button btAddNote;
    private Button btNavToItems;
    private Button btNavToSpells;
    private DndViewModel dndViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dndViewModel = new ViewModelProvider(getActivity()).get(DndViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_notes, container, false);
        btAddNote = (Button)v.findViewById(R.id.btAddNote);
        btNavToItems = (Button)v.findViewById(R.id.btNavItemsFromNotes);
        btNavToSpells = (Button)v.findViewById(R.id.btNavSpellsFromNotes);
        player = ((NotesActivity)getActivity()).getPlayer();

        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
        final NoteListAdapter adapter = new NoteListAdapter(
                new NoteListAdapter.NoteDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dndViewModel.getAllNotesOfCharacter(player.getCId()).observe(getViewLifecycleOwner(), notes -> {
            if(notes.size() > 0){
                adapter.submitList(notes);
            } else {
                Toast.makeText(getActivity(), "No notes.", Toast.LENGTH_SHORT).show();
                adapter.submitList(notes);
            }
        });


        btAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(1);
            }
        });

        btNavToItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(3);
            }
        });

        btNavToSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(6);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Note note = (Note) valinta.getTag();
                dndViewModel.setChosenNote(note);
                ((NotesActivity)getActivity()).setViewPager(2);
            }

            @Override
            public void onLongClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Note note = (Note) valinta.getTag();
                String poistettava = note.getNoteName();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("Remove note");
                builder.setMessage("Are you sure you want to remove the note: " + poistettava);
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dndViewModel.deleteNote(note);
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

package com.example.dndcharapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Note;

public class FragmentAddNote extends Fragment {
    private DndViewModel dndViewModel;
    private Character player;
    private Button btAddNote;
    private Button btBackToAllNotes;
    private EditText etNoteName;
    private EditText etNoteText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dndViewModel = new ViewModelProvider(getActivity()).get(DndViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_note, container, false);
        btAddNote = (Button)v.findViewById(R.id.btSaveNote);
        btBackToAllNotes = (Button)v.findViewById(R.id.btBackToAllNotes);
        etNoteName = (EditText)v.findViewById(R.id.etNoteName);
        etNoteText = (EditText)v.findViewById(R.id.etNoteText);
        player = ((NotesActivity)getActivity()).getPlayer();

        btAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note newNote = new Note(etNoteName.getText().toString(),
                        etNoteText.getText().toString(), player.getCId());
                dndViewModel.insertNote(newNote);
                etNoteName.setText("");
                etNoteText.setText("");
                ((NotesActivity)getActivity()).setViewPager(0);
            }
        });
        btBackToAllNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(0);
            }
        });

        return v;
    }
}

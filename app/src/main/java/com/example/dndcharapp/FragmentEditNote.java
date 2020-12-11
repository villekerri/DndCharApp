package com.example.dndcharapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Note;

public class FragmentEditNote extends Fragment {
    private DndViewModel dndViewModel;
    private Note noteToEdit;
    private Button btSaveEditedNote;
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
        View v = inflater.inflate(R.layout.fragment_edit_note, container, false);
        btSaveEditedNote = (Button)v.findViewById(R.id.btSaveNote);
        btBackToAllNotes = (Button)v.findViewById(R.id.btBackToAllNotes);
        etNoteName = (EditText)v.findViewById(R.id.etNoteName);
        etNoteText = (EditText)v.findViewById(R.id.etNoteText);

        dndViewModel.getChosenNote().observe(getViewLifecycleOwner(), note -> {
            if (note != null){
                noteToEdit = note;
                etNoteName.setText(noteToEdit.getNoteName());
                etNoteText.setText(noteToEdit.getNoteText());
            }
        });

        btSaveEditedNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteToEdit.setNoteName(etNoteName.getText().toString());
                noteToEdit.setNoteText(etNoteText.getText().toString());
                dndViewModel.updateNote(noteToEdit);
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

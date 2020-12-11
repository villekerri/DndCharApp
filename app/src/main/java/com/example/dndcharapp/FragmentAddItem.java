package com.example.dndcharapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.Note;

public class FragmentAddItem extends Fragment {
    private DndViewModel dndViewModel;
    private Character player;
    private Button btAddItem;
    private Button btBackToAllItems;
    private EditText etItemName;
    private EditText etItemNote;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dndViewModel = new ViewModelProvider(getActivity()).get(DndViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_item, container, false);
        btAddItem = (Button)v.findViewById(R.id.btSaveItem);
        btBackToAllItems = (Button)v.findViewById(R.id.btBackToAllItems);
        etItemName = (EditText)v.findViewById(R.id.etItemName);
        etItemNote = (EditText)v.findViewById(R.id.etItemNote);
        player = ((NotesActivity)getActivity()).getPlayer();

        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item newItem = new Item(etItemName.getText().toString(),
                        etItemNote.getText().toString(), player.getCId());
                dndViewModel.insertItem(newItem);
                etItemName.setText("");
                etItemNote.setText("");
                ((NotesActivity)getActivity()).setViewPager(3);
            }
        });
        btBackToAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(3);
            }
        });

        return v;
    }
}

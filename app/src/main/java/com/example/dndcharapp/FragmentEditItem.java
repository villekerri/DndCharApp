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

import com.example.dndcharapp.model.Item;

public class FragmentEditItem extends Fragment {
    private DndViewModel dndViewModel;
    private Item itemToEdit;
    private Button btSaveEditedItem;
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
        View v = inflater.inflate(R.layout.fragment_edit_item, container, false);
        btSaveEditedItem = (Button)v.findViewById(R.id.btSaveEditedItem);
        btBackToAllItems = (Button)v.findViewById(R.id.btBackToAllItems);
        etItemName = (EditText)v.findViewById(R.id.etItemName);
        etItemNote = (EditText)v.findViewById(R.id.etItemNote);
        //item = ((NotesActivity)getActivity()).getItem();

        dndViewModel.getChosenItem().observe(getViewLifecycleOwner(), item -> {
            itemToEdit = item;
            etItemName.setText(itemToEdit.getItemName());
            etItemNote.setText(itemToEdit.getItemNote());
        });

        btSaveEditedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemToEdit.setItemName(etItemName.getText().toString());
                itemToEdit.setItemNote(etItemNote.getText().toString());
                dndViewModel.updateItem(itemToEdit);
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

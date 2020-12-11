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
import com.example.dndcharapp.model.Note;

public class FragmentAllItems extends Fragment {
    private Character player;
    private Button btAddItem;
    private Button btNavToNotes;
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
        View v = inflater.inflate(R.layout.fragment_all_items, container, false);
        btAddItem = (Button)v.findViewById(R.id.btAddItem);
        btNavToNotes = (Button)v.findViewById(R.id.btNavNotesFromItems);
        btNavToSpells = (Button)v.findViewById(R.id.btNavSpellsFromItems);
        player = ((NotesActivity)getActivity()).getPlayer();

        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
        final ItemListAdapter adapter = new ItemListAdapter(
                new ItemListAdapter.ItemDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dndViewModel.getAllItemsOfCharacter(player.getCId()).observe(getViewLifecycleOwner(), items -> {
            if(items.size() > 0){
                adapter.submitList(items);
            } else {
                Toast.makeText(getActivity(), "No items.", Toast.LENGTH_SHORT).show();
                adapter.submitList(items);
            }
        });


        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(4);
            }
        });

        btNavToNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NotesActivity)getActivity()).setViewPager(0);
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
                Item item = (Item) valinta.getTag();
                dndViewModel.setChosenItem(item);
                ((NotesActivity)getActivity()).setViewPager(5);
            }

            @Override
            public void onLongClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Item item = (Item) valinta.getTag();
                String poistettava = item.getItemName();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("Remove item");
                builder.setMessage("Are you sure you want to remove the item: " + poistettava);
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dndViewModel.deleteItem(item);
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

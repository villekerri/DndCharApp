package com.example.dndcharapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dndcharapp.model.Character;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private DndViewModel dndViewModel;
    RecyclerView recyclerView;
    public static final int NEW_CHARACTER_ACTIVITY_REQUEST_CODE = 1;
    private Character choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final CharacterListAdapter adapter = new CharacterListAdapter(
                new CharacterListAdapter.CharacterDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dndViewModel = new ViewModelProvider(this).get(DndViewModel.class);
        dndViewModel.getAllCharacters().observe(this, characters -> {
            if (characters.size() > 0){
                adapter.submitList(characters);
            } else {
                Toast.makeText(MainActivity.this, "No characters.", Toast.LENGTH_SHORT).show();
                adapter.submitList(characters);
            }
        });
        dndViewModel.getChoice().observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                choice = character;
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewCharacterActivity.class);
            startActivityForResult(intent, NEW_CHARACTER_ACTIVITY_REQUEST_CODE);
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Character character = (Character) valinta.getTag();
                dndViewModel.setChoice(character);

                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                myIntent.putExtra("choice", choice);
                MainActivity.this.startActivity(myIntent);
            }

            @Override
            public void onLongClick(View view, int position) {
                TextView valinta = view.findViewById(R.id.textView);
                Character character = (Character) valinta.getTag();
                String poistettava = character.getCName();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Remove character");
                builder.setMessage("Are you sure you want to remove the character: " + poistettava);
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dndViewModel.deleteCharacter(character);
                                Toast.makeText(getApplicationContext(), poistettava + " removed.",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Removing " + poistettava +
                                        " was cancelled.",
                                Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }));

    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extraa = data.getExtras();
            Character character = (Character) extraa.getParcelable("character");
            dndViewModel.insertCharacter(character);
        } else {
            Toast.makeText(getApplicationContext(), R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
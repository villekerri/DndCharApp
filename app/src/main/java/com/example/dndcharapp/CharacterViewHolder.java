package com.example.dndcharapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dndcharapp.model.Character;

public class CharacterViewHolder extends RecyclerView.ViewHolder {
    private final TextView characterNameItemView;

    private CharacterViewHolder(View itemView){
        super(itemView);
        characterNameItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text, Character character) {
        characterNameItemView.setText(text);
        characterNameItemView.setTag(character);
    }

    static CharacterViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_item, parent, false);
        return new CharacterViewHolder(view);
    }

}

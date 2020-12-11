package com.example.dndcharapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.Spell;

public class SpellViewHolder extends RecyclerView.ViewHolder {
    private final TextView spellNameItemView;

    private SpellViewHolder(View itemView){
        super(itemView);
        spellNameItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text, Spell spell) {
        spellNameItemView.setText(text);
        spellNameItemView.setTag(spell);
    }

    static SpellViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_item, parent, false);
        return new SpellViewHolder(view);
    }

}
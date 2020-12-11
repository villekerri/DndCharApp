package com.example.dndcharapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.dndcharapp.model.Spell;

public class SpellListAdapter extends ListAdapter<Spell, SpellViewHolder> {

    public SpellListAdapter(@NonNull DiffUtil.ItemCallback<Spell> diffCallback){
        super(diffCallback);
    }

    @Override
    public SpellViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return SpellViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(SpellViewHolder holder, int position) {
        Spell current = getItem(position);
        int spellLvl = current.getSpellLevel();
        if (spellLvl == 0){
            holder.bind(current.getSpellName() + ", Cantrip\n" + current.getSpellNote(), current);
        } else {
            holder.bind(current.getSpellName() + ", Lvl. " + current.getSpellLevel() + "\n" +
                    current.getSpellNote(), current);
        }
    }

    static class SpellDiff extends DiffUtil.ItemCallback<Spell> {

        @Override
        public boolean areItemsTheSame(@NonNull Spell oldItem, @NonNull Spell newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Spell oldItem, @NonNull Spell newItem) {
            if (oldItem.getSpellName().equals(newItem.getSpellName()) == true &&
                    oldItem.getSpellLevel() == newItem.getSpellLevel()){
                return true;
            } else {
                return false;
            }
        }
    }

}
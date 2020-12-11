package com.example.dndcharapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.dndcharapp.model.Character;

public class CharacterListAdapter extends ListAdapter<Character, CharacterViewHolder> {

    public CharacterListAdapter(@NonNull DiffUtil.ItemCallback<Character> diffCallback){
        super(diffCallback);
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return CharacterViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        Character current = getItem(position);
        holder.bind(current.getCName() + "\n" + current.getCClass() + ", Level " +
                current.getCLevel(), current);
    }

    static class CharacterDiff extends DiffUtil.ItemCallback<Character> {

        @Override
        public boolean areItemsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem.getCName().equals(newItem.getCName());
        }
    }

}

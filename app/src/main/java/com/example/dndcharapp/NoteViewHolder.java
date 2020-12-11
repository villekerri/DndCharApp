package com.example.dndcharapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView noteNameItemView;

    private NoteViewHolder(View itemView){
        super(itemView);
        noteNameItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text, Note note) {
        noteNameItemView.setText(text);
        noteNameItemView.setTag(note);
    }

    static NoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_item, parent, false);
        return new NoteViewHolder(view);
    }

}

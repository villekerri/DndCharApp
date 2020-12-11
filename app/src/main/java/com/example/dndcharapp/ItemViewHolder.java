package com.example.dndcharapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dndcharapp.model.Item;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView itemNameItemView;

    private ItemViewHolder(View itemView){
        super(itemView);
        itemNameItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text, Item item) {
        itemNameItemView.setText(text);
        itemNameItemView.setTag(item);
    }

    static ItemViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

}
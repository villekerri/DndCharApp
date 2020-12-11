package com.example.dndcharapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.dndcharapp.model.Item;

public class ItemListAdapter extends ListAdapter<Item, ItemViewHolder> {

    public ItemListAdapter(@NonNull DiffUtil.ItemCallback<Item> diffCallback){
        super(diffCallback);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return ItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item current = getItem(position);
        holder.bind(current.getItemName() + "\n" + current.getItemNote(), current);
    }

    static class ItemDiff extends DiffUtil.ItemCallback<Item> {

        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.getItemName().equals(newItem.getItemName());
        }
    }

}
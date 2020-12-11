package com.example.dndcharapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertItem(Item item);

    @Update
    void updateItem(Item item);

    @Delete
    void deleteItem(Item item);

    @Query("DELETE FROM items")
    void deleteAllItems();

    @Query("SELECT * FROM items ORDER BY itemName ASC")
    LiveData<List<Item>> getItemsAlphabetized();

    @Query("SELECT * FROM items WHERE cId=:cId")
    LiveData<List<Item>> getItemsBycId(final int cId);
}

package com.example.dndcharapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.CharacterDao;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.ItemDao;
import com.example.dndcharapp.model.Note;
import com.example.dndcharapp.model.NoteDao;
import com.example.dndcharapp.model.Spell;
import com.example.dndcharapp.model.SpellDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Character.class,
        Item.class,
        Note.class,
        Spell.class
        },
        version = 1,
        exportSchema = false)
public abstract class DndRoomDb extends RoomDatabase {

    public abstract CharacterDao characterDao();
    public abstract ItemDao itemDao();
    public abstract NoteDao noteDao();
    public abstract SpellDao spellDao();

    private static volatile DndRoomDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DndRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DndRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DndRoomDb.class, "dnd_room_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            /*
            databaseWriteExecutor.execute(() -> {
                CharacterDao dao = INSTANCE.characterDao();
                dao.deleteAllCharacters();
            });
             */
        }
    };


}

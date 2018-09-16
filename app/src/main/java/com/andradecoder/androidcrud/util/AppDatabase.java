package com.andradecoder.androidcrud.util;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.andradecoder.androidcrud.modelo.Livro;

@Database(entities = {Livro.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LivroDAO livrodao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){

        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "livroRoom.sqlite").allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;
    }
}

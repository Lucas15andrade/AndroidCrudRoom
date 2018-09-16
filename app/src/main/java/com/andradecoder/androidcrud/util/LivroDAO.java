package com.andradecoder.androidcrud.util;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.andradecoder.androidcrud.modelo.Livro;

@Dao
public interface LivroDAO {

    @Insert
    long insert(Livro livro);

    @Delete
    int delete(Livro livro);

    @Query("SELECT * FROM LIVRO")
    Livro[] listarTodos();
}

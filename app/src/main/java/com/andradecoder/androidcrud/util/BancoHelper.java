package com.andradecoder.androidcrud.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.andradecoder.androidcrud.contrato.LivroContrato;
import com.andradecoder.androidcrud.modelo.Livro;

import java.util.ArrayList;
import java.util.List;

public class BancoHelper extends SQLiteOpenHelper {

    private static final String nomeBanco = "bancoLivro.sqlite";
    private static final int versaoBanco = 1;
    //String para criação da tabela Livro
    private static final String criarTabela = "create table "+LivroContrato.LivroEntry.TABLE_NAME+
            " ("+ LivroContrato.LivroEntry._ID+" integer primary key,"+
            " "+ LivroContrato.LivroEntry.TITULO+" text,"+
            " "+ LivroContrato.LivroEntry.AUTOR+" text,"+
            " "+ LivroContrato.LivroEntry.ANO+" text,"+
            " "+ LivroContrato.LivroEntry.NOTA+" text);";

    public BancoHelper(Context context) {
        super(context, nomeBanco, null, versaoBanco);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(criarTabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Métodos do CRUD

    public void salvar(Livro livro){
        long id = livro.getId();
        SQLiteDatabase db = getWritableDatabase();

        try {

            ContentValues cv = new ContentValues();

            cv.put(LivroContrato.LivroEntry.TITULO, livro.getTitulo());
            cv.put(LivroContrato.LivroEntry.AUTOR, livro.getAutor());
            cv.put(LivroContrato.LivroEntry.ANO, livro.getAno());
            cv.put(LivroContrato.LivroEntry.NOTA, livro.getNota());

            if(id != 0){
               String selection = LivroContrato.LivroEntry._ID + " = ?";
               String[] whereargs = new String[]{String.valueOf(id)};

               db.update(LivroContrato.LivroEntry.TABLE_NAME, cv, selection, whereargs);

            } else{
                db.insert(LivroContrato.LivroEntry.TABLE_NAME, null, cv);
            }

        }finally {
            db.close();
        }
    }

    public List<Livro> listarTodos(){
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.query(LivroContrato.LivroEntry.TABLE_NAME, null, null, null, null, null, null);
            return toList(c);
        }finally {
            db.close();
        }
    }

    private List<Livro> toList(Cursor c){
        List<Livro> listaLivro = new ArrayList<>();

        if(c.moveToFirst()){
            do {
                Livro livro = new Livro();
                listaLivro.add(livro);

                livro.setId(c.getInt(c.getColumnIndex(LivroContrato.LivroEntry._ID)));
                livro.setAutor(c.getString(c.getColumnIndex(LivroContrato.LivroEntry.AUTOR)));
                livro.setTitulo(c.getString(c.getColumnIndex(LivroContrato.LivroEntry.TITULO)));
                livro.setNota(c.getString(c.getColumnIndex(LivroContrato.LivroEntry.NOTA)));
                livro.setAno(c.getString(c.getColumnIndex(LivroContrato.LivroEntry.ANO)));
            }while(c.moveToNext());
        }
        return listaLivro;
    }

    public void execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
        } finally {
            db.close();
        }
    }
}

package com.andradecoder.androidcrud.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.andradecoder.androidcrud.R;
import com.andradecoder.androidcrud.modelo.Livro;
import com.andradecoder.androidcrud.util.AppDatabase;
import com.andradecoder.androidcrud.util.LivroAdapter;
import com.andradecoder.androidcrud.util.LivroDAO;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    //Branch room

    int cont = 1;
    int voltar = cont - 1;
    TextView textTitulo;
    TextView textAutor;
    TextView textAno;
    TextView textNota;
    //ArrayList<Livro> livros;
    ArrayList<Livro> livros;
    AppDatabase db;
    LivroDAO livrodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        db = AppDatabase.getDatabase(this);
        livrodao = db.livrodao();
        livros = (ArrayList<Livro>) livrodao.listarTodos();

        ListView lista = findViewById(R.id.lista);
        LivroAdapter livroAdapter = new LivroAdapter(this, livros);
        lista.setAdapter(livroAdapter);
    }
}

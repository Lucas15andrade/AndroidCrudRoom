package com.andradecoder.androidcrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.andradecoder.androidcrud.modelo.Livro;
import com.andradecoder.androidcrud.util.AppDatabase;
import com.andradecoder.androidcrud.util.LivroDAO;

import java.util.ArrayList;

public class BuscarActivity extends AppCompatActivity {

    AppDatabase db;
    LivroDAO livrodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        final TextView textTitulo = findViewById(R.id.textTitulo);
        TextView textAutor = findViewById(R.id.textAutor);

        db = AppDatabase.getDatabase(this);
        livrodao = db.livrodao();
        ArrayList<Livro> livros = (ArrayList<Livro>) livrodao.listarTodos();

        String[] livrosString = new String[livros.size()];

        for (int x = 0; x < livros.size(); x++) {
            livrosString[x] = livros.get(x).getTitulo();
        }

        AutoCompleteTextView autoComplete = findViewById(R.id.autoComplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, livrosString);
        autoComplete.setAdapter(adapter);

        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Implementar
            }
        });
    }
}

package com.andradecoder.androidcrud.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andradecoder.androidcrud.R;
import com.andradecoder.androidcrud.modelo.Livro;
import com.andradecoder.androidcrud.util.AppDatabase;
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
    Livro[] livros;
    AppDatabase db;
    LivroDAO livrodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        textTitulo = findViewById(R.id.textTitulo);
        textAutor = findViewById(R.id.textAutor);
        textAno = findViewById(R.id.textAno);
        textNota = findViewById(R.id.textNota);

        db = AppDatabase.getDatabase(this);
        livrodao = db.livrodao();
        //livros = new ArrayList<>();
        livros =  livrodao.listarTodos();

        if(cont == 1){
            if(livros.length > 0){
                //Preenchendo com o primeiro Livro
                textTitulo.setText(livros[0].getTitulo());
                textAutor.setText(livros[0].getAutor());
                textAno.setText(livros[0].getAno());
                textNota.setText(livros[0].getNota());

            }
        }

        Button botaoProximo = findViewById(R.id.botaoProximo);
        botaoProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cont >= livros.length){
                    Toast.makeText(ListarActivity.this, "Não há mais livros", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    textTitulo.setText(livros[cont].getTitulo());
                    textAutor.setText(livros[cont].getAutor());
                    textAno.setText(livros[cont].getAno());
                    textNota.setText(livros[cont].getNota());
                    cont++;
//                    voltar = cont - 1;
                    Log.i("voltar","avançou");
                }

                //cont++;

            }
        });

        Button botaoAnterior = findViewById(R.id.botaoAnterior);
        botaoAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("avancar","botao retroceder"+cont);
                --cont;
                Log.i("avancar","botao retroceder"+cont);
                if(cont < 0){
                    Toast.makeText(ListarActivity.this, "Impossível retroceder", Toast.LENGTH_SHORT).show();
                } else{
                    Log.i("avancar","botao retroceder"+cont);
                    Log.i("avancar","titulo"+livros[cont].getTitulo());
                    if(!(cont - 1 < 0)){
                        textTitulo.setText(livros[cont-1].getTitulo());
                        textAutor.setText(livros[cont-1].getAutor());
                        textAno.setText(livros[cont-1].getAno());
                        textNota.setText(livros[cont-1].getNota());
                    }

                }

            }
        });
    }
}

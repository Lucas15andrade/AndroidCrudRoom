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
import com.andradecoder.androidcrud.util.BancoHelper;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    int cont = 1;
    int voltar = cont - 1;
    TextView textTitulo;
    TextView textAutor;
    TextView textAno;
    TextView textNota;
    ArrayList<Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        textTitulo = findViewById(R.id.textTitulo);
        textAutor = findViewById(R.id.textAutor);
        textAno = findViewById(R.id.textAno);
        textNota = findViewById(R.id.textNota);

        BancoHelper db = new BancoHelper(getApplicationContext());
        livros = new ArrayList<>();
        livros = (ArrayList<Livro>) db.listarTodos();

        if(livros.size() > 0){
            //Preenchendo com o primeiro Livro
            textTitulo.setText(livros.get(0).getTitulo());
            textAutor.setText(livros.get(0).getAutor());
            textAno.setText(livros.get(0).getAno());
            textNota.setText(livros.get(0).getNota());

        }

        Button botaoProximo = findViewById(R.id.botaoProximo);
        botaoProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cont >= livros.size()){
                    Toast.makeText(ListarActivity.this, "Não há mais livros", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    textTitulo.setText(livros.get(cont).getTitulo());
                    textAutor.setText(livros.get(cont).getAutor());
                    textAno.setText(livros.get(cont).getAno());
                    textNota.setText(livros.get(cont).getNota());
                    cont++;
                    voltar = cont - 1;
                    Log.i("voltar","avançou");
                }

                //cont++;
                
            }
        });

        Button botaoAnterior = findViewById(R.id.botaoAnterior);
        botaoAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltar--;
                if(voltar >= 0){
                    textTitulo.setText(livros.get(voltar).getTitulo());
                    textAutor.setText(livros.get(voltar).getAutor());
                    textAno.setText(livros.get(voltar).getAno());
                    textNota.setText(livros.get(voltar).getNota());
                    Log.i("voltar","valor de cont:"+voltar);
                } else{
                    Toast.makeText(ListarActivity.this, "Não tem como voltar", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

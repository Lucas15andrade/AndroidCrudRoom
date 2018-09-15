package com.andradecoder.androidcrud.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andradecoder.androidcrud.R;

public class ListarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        TextView textTitulo = findViewById(R.id.textTitulo);
        TextView textAutor = findViewById(R.id.textAutor);
        TextView textAno = findViewById(R.id.textAno);
        TextView textNota = findViewById(R.id.textNota);


        Button botaoProximo = findViewById(R.id.botaoProximo);
        botaoProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button botaoAnterior = findViewById(R.id.botaoAnterior);
        botaoAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

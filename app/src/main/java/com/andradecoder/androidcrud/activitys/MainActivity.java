package com.andradecoder.androidcrud.activitys;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andradecoder.androidcrud.BuscarActivity;
import com.andradecoder.androidcrud.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        Button botaoListar = findViewById(R.id.botaoListar);
        botaoListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListarActivity.class);
                startActivityForResult(intent,2);
            }
        });

        Button botaoBuscar = findViewById(R.id.botaoBuscar);
        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuscarActivity.class);
                startActivityForResult(intent, 3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null){
            return;
        }

        Bundle bd = data.getExtras();
        Boolean salvar = bd.getBoolean("salvar");
        if(resultCode == RESULT_OK && requestCode == 1){
            if(salvar){
                View v = findViewById(R.id.layout);
                Snackbar snack = Snackbar.make((View) v.getParent(),"Livro cadastrado", Snackbar.LENGTH_SHORT);
                snack.show();
            }
        }
    }
}

package com.andradecoder.androidcrud.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.andradecoder.androidcrud.R;
import com.andradecoder.androidcrud.modelo.Livro;
import com.andradecoder.androidcrud.util.BancoHelper;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final EditText editTitulo = findViewById(R.id.editTitulo);
        final EditText editAutor = findViewById(R.id.editAutor);
        final EditText editAno = findViewById(R.id.editAno);
        final RatingBar ratingNota = findViewById(R.id.ratingNota);

        Button botaoSalvar = findViewById(R.id.botaoSalvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro livro = new Livro(editTitulo.getText().toString(), editAutor.getText().toString(), editAno.getText().toString(), Float.toString(ratingNota.getRating()));
                BancoHelper db = new BancoHelper(getApplicationContext());

                db.salvar(livro);
                finish();
            }
        });

        Button botaoCancelar = findViewById(R.id.botaoCancelar);
        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

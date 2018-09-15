package com.andradecoder.androidcrud.contrato;

import android.provider.BaseColumns;

//Criado por @AndradeCoder

public final class LivroContrato {

    private LivroContrato() {
    }

    public static class LivroEntry implements BaseColumns {
        public static final String TABLE_NAME = "Livro";
        public static final String TITULO = "titulo";
        public static final String AUTOR = "autor";
        public static final String ANO = "ano";
        public static final String NOTA = "nota";
    }
}

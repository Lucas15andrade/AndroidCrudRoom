package com.andradecoder.androidcrud.util;

import android.view.View;
import android.widget.TextView;

import com.andradecoder.androidcrud.R;

public class ViewHolder {
    TextView textTitulo;
    TextView textAutor;

    public ViewHolder(View v) {
        this.textTitulo = v.findViewById(R.id.textTitulo);
        this.textAutor = v.findViewById(R.id.textAutor);
    }
}

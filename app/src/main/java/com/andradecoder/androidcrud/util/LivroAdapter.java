package com.andradecoder.androidcrud.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.andradecoder.androidcrud.R;
import com.andradecoder.androidcrud.modelo.Livro;

import java.util.List;

public class LivroAdapter extends BaseAdapter {

    Context context;
    List<Livro> livros;

    public LivroAdapter(Context context, List<Livro> livros) {
        super();
        this.context = context;
        this.livros = livros;
    }

    @Override
    public int getCount() {
        return livros != null ? livros.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return livros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view;
        ViewHolder holder;

        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.livro_inflater,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }

        //Preenchendo os dados

        Livro livro = livros.get(i);
        holder.textAutor.setText(livro.getAutor());
        holder.textTitulo.setText(livro.getTitulo());

        return view;
    }
}

package com.andradecoder.androidcrud.modelo;

public class Livro {

    private String titulo;
    private String autor;
    private String ano;
    private String nota;
    private int id;

    public Livro() {

    }

    public Livro(String titulo, String autor, String ano, String nota){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.nota = nota;
        //this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}

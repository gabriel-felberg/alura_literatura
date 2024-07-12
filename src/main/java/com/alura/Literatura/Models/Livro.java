package com.alura.Literatura.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros")

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String título;

    @Column(name = "idiomas")
    private String idiomas;

    @Column(name = "downloads")
    private int downloads;

    @Column(name = "autor")
    public String autor;

    public Livro() {}

    public Livro(DadosLivro dados) {
        this.título = dados.Título();
        this.idiomas = String.join(",", dados.Idiomas());
        this.downloads = dados.Downloads();
        this.autor = dados.Autor();
    }

    public Long getId() {
        return id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = String.valueOf(autor);
    }

    @Override
    public String toString() {
        return  "**********************" + '\n' +
                "Livro: " + título + '\n' +
                "Idiomas: " + idiomas + '\n' +
                "Downloads: " + downloads + '\n' +
                "Autor: " + autor + '\n' +
                "**********************";
    }
}

package com.alura.Literatura.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name= "Autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("name")
    private String nome;
    @JsonAlias("birth_year")
    private int dataNascimento;
    @JsonAlias("death_year")
    private int dataFalecimento;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "autor")
    //private List<Livro> livros;

    public Autor(DadosAutor dados) {
        System.out.println(dados.Nome());
        System.out.println("oiiiiiiiiiii");
        this.nome = dados.Nome();
        this.dataNascimento = dados.DataNascimento();
        this.dataFalecimento = dados.DataFalecimento();
    }

    public Autor() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataFalecimento(int dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getNome() {
        return nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public int getDataFalecimento() {
        return dataFalecimento;
    }

    @Override
    public String toString() {
        return  "**********************" + '\n' +
                "Autor: " + nome + '\n' +
                "Ano de Nascimento: " + dataNascimento + '\n' +
                "Ano de Falecimento: " + dataFalecimento + '\n' +
                "**********************";
    }
}

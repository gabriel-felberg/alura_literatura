package com.alura.Literatura.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias("title") String Título,
        @JsonAlias("author") String Autor,
        @JsonAlias("languages") List<String> Idiomas,
        @JsonAlias("download_count") int Downloads
) {}

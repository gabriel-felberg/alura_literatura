package com.alura.Literatura.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(
        @JsonAlias("name") String Nome,
        @JsonAlias("birth_year") int DataNascimento,
        @JsonAlias("death_year") int DataFalecimento
) {}

package com.alura.Literatura.Services;

public interface IConverteDados {
    <T> T  obterDadosLivro(String json, Class<T> classe);
    <T> T  obterDadosAutor(String json, Class<T> classe);
}

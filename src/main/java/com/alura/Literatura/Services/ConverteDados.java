package com.alura.Literatura.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDadosLivro(String json, Class<T> classe) {
        try {
            JsonNode root = mapper.readTree(json);
            JsonNode resultsNode = root.path("results").get(0);

            System.out.println(resultsNode);
            return mapper.readValue(resultsNode.toString(), classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T obterDadosAutor(String json, Class<T> classe) {
        try {
            JsonNode root = mapper.readTree(json);
            JsonNode resultsNode = root.path("results").get(0).path("authors").get(0);

            System.out.println(resultsNode);
            return mapper.readValue(resultsNode.toString(), classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
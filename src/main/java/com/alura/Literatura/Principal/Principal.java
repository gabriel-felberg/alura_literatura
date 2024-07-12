package com.alura.Literatura.Principal;

import com.alura.Literatura.Models.Autor;
import com.alura.Literatura.Models.DadosAutor;
import com.alura.Literatura.Models.DadosLivro;
import com.alura.Literatura.Models.Livro;
import com.alura.Literatura.Repositoty.AutorRepository;
import com.alura.Literatura.Repositoty.LivroRepository;
import com.alura.Literatura.Services.ConsumoAPI;
import com.alura.Literatura.Services.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

    @Autowired
    public LivroRepository repositoryLivro;

    @Autowired
    public AutorRepository repositoryAutor;


    public void chat() {
        int opcao;
        do {
            opcao = messagemInicial();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String livroNome = leitura.nextLine();
                    String json = consumo.obterDados("https://gutendex.com/books?search=" + livroNome.replace(" ", "+"));

                    ConverteDados conversor = new ConverteDados();
                    DadosLivro dadosLivro = conversor.obterDadosLivro(json, DadosLivro.class);
                    DadosAutor dadosAutor = conversor.obterDadosAutor(json, DadosAutor.class);


                    if (dadosLivro != null && dadosAutor != null) {

                        Livro livro = new Livro(dadosLivro);
                        Autor autor = new Autor(dadosAutor);

                        repositoryLivro.save(livro);
                        repositoryAutor.save(autor);
                        System.out.println("Livro salvo com sucesso!");
                    } else {
                        System.out.println("Não foi possível obter dados válidos do JSON.");
                    }

                    break;
                case 2:
                    buscarLivros();
                    break;
                case 3:
                    buscarAutores();
                    break;
                case 4:
                    buscarAutoresPorAno();
                    break;
                case 5:
                    buscarAutoresPorLinguagem();
                    break;
                case 0:
                    System.out.println("Programa Finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void buscarAutoresPorLinguagem() {
        Set<String> siglas = new HashSet<>(repositoryLivro.findByIdiomas());
        System.out.println("Siglas disponíveis: ");
        siglas.forEach(System.out::println);

        System.out.println("Digite a sigla do idioma: ");
        String sigla = leitura.nextLine();
        List<Livro> livros = repositoryLivro.findByIdiomas(sigla);
        livros.forEach(livro -> System.out.println(livro.toString()));
    }

    private void buscarLivros() {
        List<Livro> livros = repositoryLivro.findAll();
        livros.forEach(livro -> System.out.println(livro.toString()));
    }

    private void buscarAutores() {
        List<Autor> autores = repositoryAutor.findAll();
        autores.forEach(livro -> System.out.println(livro.toString()));
    }
    private void buscarAutoresPorAno() {
        System.out.println("Digite o ano do autor: ");
        int ano = leitura.nextInt();
        List<Autor> autores = repositoryAutor.findByDataNascimentoGreaterThanEqual(ano);
        autores.forEach(autor -> System.out.println(autor.toString()));
    }
    int messagemInicial() {
        System.out.println("""
                1- Pesquisar Livro
                2- Buscar Livros
                3- Buscar Autores
                4- Buscar Autores vivos de um ano
                5- Buscar Livros de uma linguagem
                0- Sair
                """);
        System.out.print("Escolha uma opção: ");
        while (!leitura.hasNextInt()) {
            System.out.print("Por favor, insira um número válido: ");
            leitura.next();
        }
        int opcao = leitura.nextInt();
        leitura.nextLine(); // Limpar o buffer do scanner
        return opcao;
    }
}

package com.alura.Literatura.Repositoty;

import com.alura.Literatura.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LivroRepository  extends JpaRepository<Livro, Long> {
    List<Livro> findAll();

    @Query("SELECT l.idiomas FROM Livro l")
    List<String> findByIdiomas();

    List<Livro> findByIdiomas(String linguagem);
}

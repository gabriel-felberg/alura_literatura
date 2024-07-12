package com.alura.Literatura.Repositoty;


import com.alura.Literatura.Models.Autor;
import com.alura.Literatura.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findAll();

    List<Autor> findByDataNascimentoGreaterThanEqual(int year);
}

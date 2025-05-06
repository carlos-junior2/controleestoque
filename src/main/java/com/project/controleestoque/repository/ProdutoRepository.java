package com.project.controleestoque.repository;

import com.project.controleestoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findByNomeAndDescricaoIgnoreCase(String nome, String descricao);

    Produto getById(Integer id);

}

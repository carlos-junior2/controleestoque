package com.project.controleestoque.service;

import com.project.controleestoque.model.Produto;
import com.project.controleestoque.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        Optional<Produto> existente = produtoRepository.findByNomeAndDescricaoIgnoreCase(produto.getNome(), produto.getDescricao());
        if (existente.isPresent()){
            Integer id = existente.get().getId();
            produto.setId(id);
            registrarEntrada(produto);
        }

        produtoRepository.save(produto);
        return produto;
    }

    public Produto registrarEntrada(Produto produto){
        Integer id = produto.getId();
        Produto produtoEstoque = produtoRepository.getById(id);
        Integer qtdEstoque = produtoEstoque.getQuantidade();
        Integer qtdFinal = produto.getQuantidade() + qtdEstoque;
        produto.setQuantidade(qtdFinal);

        produtoRepository.save(produto);
        return produto;
    }

}

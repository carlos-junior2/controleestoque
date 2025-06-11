package com.project.controleestoque.service;

import com.project.controleestoque.model.Produto;
import com.project.controleestoque.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            registrarEntrada(produto.getId(), produto.getQuantidade());
            return produto;
        }

        produtoRepository.save(produto);
        return produto;
    }

    public Produto registrarEntrada(Integer id, Integer quantidade){
        Produto produto = produtoRepository.getById(id);
        Integer qtdFinal = produto.getQuantidade() + quantidade;
        produto.setQuantidade(qtdFinal);

        produtoRepository.save(produto);
        return produto;
    }

    public Produto registrarSaida(Integer id, Integer quantidade) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        if (quantidade <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A quantidade de saída deve ser maior que zero");
        }

        if (produto.getQuantidade() < quantidade) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Quantidade em estoque (" + produto.getQuantidade() + ") é insuficiente para saída de " + quantidade);
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        return produtoRepository.save(produto);
    }

    public Produto obterProduto(Integer id){
        return produtoRepository.getById(id);
    }

}

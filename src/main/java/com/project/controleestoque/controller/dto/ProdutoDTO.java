package com.project.controleestoque.controller.dto;

import com.project.controleestoque.model.Categoria;
import com.project.controleestoque.model.Produto;
import lombok.*;

@Data
@NoArgsConstructor
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private Integer estoqueMinimo;
    private Integer categoria;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.quantidade = produto.getQuantidade();
        this.estoqueMinimo = produto.getEstoqueMinimo();
        this.categoria = produto.getCategoria().getId();
    }

    public Produto toEntity(Categoria categoria){
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setQuantidade(this.quantidade);
        produto.setEstoqueMinimo(this.estoqueMinimo);
        produto.setCategoria(categoria);

        return produto;
    }
}

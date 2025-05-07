package com.project.controleestoque.controller.dto;

import com.project.controleestoque.model.Movimentacao;
import com.project.controleestoque.model.Produto;
import com.project.controleestoque.model.Tipo;
import com.project.controleestoque.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MovimentacaoDTO {
    private Integer id;
    private Tipo tipo;
    private LocalDateTime data;
    private Integer quantidade;
    private Integer produtoId;
    private Integer usuarioId;

    public void toDTO(Movimentacao movimentacao) {
        this.id = movimentacao.getId();
        this.tipo = movimentacao.getTipo();
        this.data = movimentacao.getData();
        this.quantidade = movimentacao.getQuantidade();
        this.produtoId = movimentacao.getProduto().getId();
        this.usuarioId = movimentacao.getUsuario().getId();
    }

    public Movimentacao toEntity(Produto produto, Usuario usuario){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setId(this.getId());
        movimentacao.setTipo(this.getTipo());
        movimentacao.setData(this.getData());
        movimentacao.setQuantidade(this.getQuantidade());
        movimentacao.setProduto(produto);
        movimentacao.setUsuario(usuario);

        return movimentacao;
    }

}

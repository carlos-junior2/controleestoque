package com.project.controleestoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "produto")
public class Produto {

    @Id
    @Column(name= "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "nome", length = 50, nullable = false)
    private String nome;

    @Column(name="descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "estoque_minimo", nullable = false)
    private Integer estoqueMinimo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

}

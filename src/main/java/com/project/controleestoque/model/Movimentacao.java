package com.project.controleestoque.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo", length = 7, nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "data", nullable = false)
    @CreatedDate
    private LocalDateTime data;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @JoinColumn(name = "produto_id", nullable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    @JoinColumn(name = "usuario_id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

}

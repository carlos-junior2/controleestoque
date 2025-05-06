package com.project.controleestoque.controller;

import com.project.controleestoque.controller.dto.ProdutoDTO;
import com.project.controleestoque.model.Categoria;
import com.project.controleestoque.model.Produto;
import com.project.controleestoque.service.CategoriaService;
import com.project.controleestoque.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody ProdutoDTO dto){
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoria())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada"));
        Produto produto = dto.toEntity(categoria);
        produtoService.salvar(produto);
        URI uri = URI.create("/" + produto.getId());
        return ResponseEntity.created(uri).body(dto);
    }
}

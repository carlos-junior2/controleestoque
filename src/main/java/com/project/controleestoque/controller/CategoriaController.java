package com.project.controleestoque.controller;

import com.project.controleestoque.model.Categoria;
import com.project.controleestoque.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria){
        categoriaService.salvar(categoria);
        URI uri = URI.create("/" + categoria.getId());
        return ResponseEntity.created(uri).body(categoria);
    }
}

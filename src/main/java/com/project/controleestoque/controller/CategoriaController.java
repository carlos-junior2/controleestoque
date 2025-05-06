package com.project.controleestoque.controller;

import com.project.controleestoque.model.Categoria;
import com.project.controleestoque.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria);
    }
}

package com.project.controleestoque.service;

import com.project.controleestoque.model.Categoria;
import com.project.controleestoque.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> buscarPorId(Integer id){
        return categoriaRepository.findById(id);
    }
}

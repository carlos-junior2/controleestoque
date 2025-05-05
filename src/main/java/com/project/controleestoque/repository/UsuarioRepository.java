package com.project.controleestoque.repository;

import com.project.controleestoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT MAX(u.id) FROM Usuario u")
    Integer findMaxId();
}

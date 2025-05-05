package com.project.controleestoque.service;

import com.project.controleestoque.model.Usuario;
import com.project.controleestoque.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        if (usuario.getId() == null) {
            Integer maxId = usuarioRepository.findMaxId();
            usuario.setId((maxId == null ? 1 : maxId + 1));
        }
        return usuarioRepository.save(usuario);
    }
}

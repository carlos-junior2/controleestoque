package com.project.controleestoque.service;

import com.project.controleestoque.exception.RegistroDuplicadoException;
import com.project.controleestoque.model.Usuario;
import com.project.controleestoque.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        if(usuarioRepository.existsByUsername(usuario.getUsername())){
            throw new RegistroDuplicadoException("O Usuário " + usuario.getUsername() + " já esta cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }
}

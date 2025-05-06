package com.project.controleestoque.controller;

import com.project.controleestoque.model.Usuario;
import com.project.controleestoque.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioControler {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        URI uri = URI.create("/" + usuario.getId());
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/test")
    public String testarAPI(){
        return "Bem vindo a API de usuarios!";
    }

}

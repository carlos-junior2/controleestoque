package com.project.controleestoque.controller;

import com.project.controleestoque.model.Usuario;
import com.project.controleestoque.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioControler {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        System.out.println(usuario);
        usuarioService.salvar(usuario);
        return usuario;
    }

    @GetMapping("/test")
    public String testarAPI(){
        return "Bem vindo a API de usuarios!";
    }

}

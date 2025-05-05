package com.project.controleestoque.controller;

import com.project.controleestoque.model.Usuario;
import com.project.controleestoque.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

    private UsuarioService usuarioService;

    public UsuarioControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

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

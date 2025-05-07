package com.project.controleestoque.controller.dto;

import com.project.controleestoque.model.Role;
import com.project.controleestoque.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String username;
    private String senha;
    private Role role;

    public void toDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
        this.senha = usuario.getSenha();
        this.role = usuario.getRole();
    }

    public Usuario toEntity(){
        Usuario usuario = new Usuario();

        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setUsername(this.username);
        usuario.setSenha(this.senha);
        usuario.setRole(this.role);

        return usuario;
    }
}

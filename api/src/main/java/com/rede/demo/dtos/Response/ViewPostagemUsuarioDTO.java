package com.rede.demo.dtos.Response;

import com.rede.demo.domain.Usuario;

public record ViewPostagemUsuarioDTO(
        String nome,
        String username
) {
    public ViewPostagemUsuarioDTO(Usuario usuario){
        this(
                usuario.getNome(),
                usuario.getUsername()
        );
    }
}

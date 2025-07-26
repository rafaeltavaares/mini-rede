package com.rede.demo.dtos.Response;

import com.rede.demo.domain.Usuario;

import java.time.LocalDateTime;
public record UsuarioResponseDTO(
        String username,
        String email,
        String nome,
        String telefone,
        LocalDateTime criado_em
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getCriado_em()
        );
    }
}

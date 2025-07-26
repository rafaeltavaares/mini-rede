package com.rede.demo.dtos.Request;

public record CreateUsuarioRequestDTO(
         String username,
         String nome,
         String senha,
         String email,
         String telefone
) {
}

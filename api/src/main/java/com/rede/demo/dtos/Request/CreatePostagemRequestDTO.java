package com.rede.demo.dtos.Request;

import com.rede.demo.domain.Flags.Categoria;
import com.rede.demo.domain.Flags.Privacidade;

public record CreatePostagemRequestDTO(
    String conteudo,
    String titulo,
    UsuarioPostagemDTO usuario,
    Categoria categoria,
    Privacidade Privacidade
) {
}

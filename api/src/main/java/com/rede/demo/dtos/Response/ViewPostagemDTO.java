package com.rede.demo.dtos.Response;

import com.rede.demo.domain.Postagem;

import java.time.LocalDateTime;

public record ViewPostagemDTO(
        Long id,
        String conteudo,
        ViewPostagemUsuarioDTO usuario,
        LocalDateTime criado_em

) {
    public ViewPostagemDTO(Postagem postagem) {
        this(
                postagem.getId(),
                postagem.getConteudo(),
                new ViewPostagemUsuarioDTO(postagem.getUsuario()),
                postagem.getCriado_em()

        );
    }
}
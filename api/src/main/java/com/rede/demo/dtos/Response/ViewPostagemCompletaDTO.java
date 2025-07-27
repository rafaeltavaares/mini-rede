package com.rede.demo.dtos.Response;

import com.rede.demo.domain.Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record ViewPostagemCompletaDTO(
        Long id,
        String conteudo,
        ViewPostagemUsuarioDTO usuario,
        LocalDateTime criado_em,
        List<ViewPostagemCompletaDTO> respostas
) {
    public ViewPostagemCompletaDTO(Postagem postagem) {
        this(
                postagem.getId(),
                postagem.getConteudo(),
                new ViewPostagemUsuarioDTO(postagem.getUsuario()),
                postagem.getCriado_em(),
                new ArrayList<>()
        );
    }

    public ViewPostagemCompletaDTO withRespostas(List<ViewPostagemCompletaDTO> respostas) {
        return new ViewPostagemCompletaDTO(id, conteudo, usuario, criado_em, respostas);
    }
}
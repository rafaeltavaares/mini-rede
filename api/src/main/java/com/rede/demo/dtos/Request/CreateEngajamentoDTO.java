package com.rede.demo.dtos.Request;

import com.rede.demo.domain.Flags.Taxonomia;

public record CreateEngajamentoDTO(

        Long usuarioId,
        Long postagemId,
        Taxonomia taxonomia
) {
}

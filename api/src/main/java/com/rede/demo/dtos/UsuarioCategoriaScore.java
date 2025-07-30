package com.rede.demo.dtos;

import com.rede.demo.domain.Flags.Categoria;

public record UsuarioCategoriaScore(
        Categoria categoria,
        Double score

) {
}

package com.rede.demo.dtos.Request;

import com.rede.demo.domain.Flags.Categoria;

public record CategoriaScoreDTO(
        Categoria categoria,
        Double score
) {
}

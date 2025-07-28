package com.rede.demo.dtos.Request;

import java.util.List;

public record CreateUsuarioPreferenciaDTO(
        Long usuarioid,
        List<CategoriaScoreDTO> preferencias
) {
}

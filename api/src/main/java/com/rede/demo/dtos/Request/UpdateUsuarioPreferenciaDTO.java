package com.rede.demo.dtos.Request;

import java.util.List;

public record UpdateUsuarioPreferenciaDTO(
        Long usuarioid,
        List<CategoriaScoreDTO> preferencias
) {
}

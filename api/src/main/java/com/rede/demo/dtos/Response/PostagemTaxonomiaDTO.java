package com.rede.demo.dtos.Response;

import com.rede.demo.domain.Flags.Taxonomia;
import com.rede.demo.domain.Postagem;

import java.util.ArrayList;
import java.util.List;

public record PostagemTaxonomiaDTO(
        ViewPostagemDTO postagem,
        List<Taxonomia> taxonomia
) {
    public PostagemTaxonomiaDTO(Postagem postagem, List<Taxonomia> taxonomia){
        this(new ViewPostagemDTO(postagem), taxonomia);
    }
}

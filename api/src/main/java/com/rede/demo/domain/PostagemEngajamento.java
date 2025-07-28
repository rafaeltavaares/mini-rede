package com.rede.demo.domain;

import com.rede.demo.domain.Flags.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class PostagemEngajamento {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postagem_id", nullable = false)
    private Postagem postagem;

    private Categoria categoria;

    private Double Score;

    private Double mediaRetencao;

    private Long Curtidas;

    private Long Comentarios;

    private Long compartilhamentos;

    private LocalDateTime criadoEm;


}

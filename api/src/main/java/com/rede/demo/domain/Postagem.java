package com.rede.demo.domain;


import com.rede.demo.dtos.Request.CreatePostagemRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import com.rede.demo.domain.Flags.Categoria;
import com.rede.demo.domain.Flags.Privacidade;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String conteudo;

    private String titulo;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Privacidade privacidade;

    private LocalDateTime criado_em;


    public Postagem (CreatePostagemRequestDTO data, Usuario usuario){
        this.conteudo = data.conteudo();
        this.titulo = data.titulo();
        this.usuario = usuario;
        this.categoria = data.categoria();
        this.criado_em = LocalDateTime.now();
        this.privacidade = data.Privacidade();
    }
    public Postagem(){}
    public Postagem(UUID id, String conteudo, String titulo, Usuario usuario, Categoria categoria, Privacidade privacidade, LocalDateTime criado_em) {
        this.id = id;
        this.conteudo = conteudo;
        this.titulo = titulo;
        this.usuario = usuario;
        this.categoria = categoria;
        this.privacidade = privacidade;
        this.criado_em = criado_em;
    }

    public Postagem(CreatePostagemRequestDTO data) {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Privacidade getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(Privacidade privacidade) {
        this.privacidade = privacidade;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }
}

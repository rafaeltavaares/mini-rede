package com.rede.demo.domain;


import com.rede.demo.dtos.Request.CreatePostagemRequestDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import com.rede.demo.domain.Flags.Categoria;
import com.rede.demo.domain.Flags.Privacidade;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Privacidade privacidade;

    private LocalDateTime criadoEm;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "resposta_ao_id")
    private Postagem respostaAo;


    public Postagem (CreatePostagemRequestDTO data, Usuario usuario){
        this.conteudo = data.conteudo();
        this.usuario = usuario;
        this.categoria = data.categoria();
        this.criadoEm = LocalDateTime.now();
        this.privacidade = data.Privacidade();

    }


    public Postagem (CreatePostagemRequestDTO data, Usuario usuario,Postagem respostaAo){
        this.conteudo = data.conteudo();
        this.usuario = usuario;
        this.categoria = data.categoria();
        this.criadoEm = LocalDateTime.now();
        this.privacidade = data.Privacidade();
        this.respostaAo = respostaAo;

    }

    public Postagem(){}
    public Postagem(Long id, String conteudo, String titulo, Usuario usuario, Categoria categoria, Privacidade privacidade, LocalDateTime criadoEm) {
        this.id = id;
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.categoria = categoria;
        this.privacidade = privacidade;
        this.criadoEm = criadoEm;
    }

    public Postagem(CreatePostagemRequestDTO data) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Postagem getResposta_ao() {return respostaAo;}

    public void setResposta_ao(Postagem resposta_ao) {this.respostaAo = resposta_ao;}

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
        return criadoEm;
    }

    public void setCriado_em(LocalDateTime criado_em) {
        this.criadoEm = criado_em;
    }
}

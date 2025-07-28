package com.rede.demo.domain;

import com.rede.demo.dtos.Request.CreateUsuarioPreferenciaDTO;
import jakarta.persistence.*;
import lombok.*;
import com.rede.demo.domain.Flags.Categoria;

import java.util.List;

@Entity
public class PreferenciaUsuario {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private Double score;


    public PreferenciaUsuario(Usuario usuario, Double score, Categoria categoria){
        this.categoria = categoria;
        this.score = score;
        this.usuario = usuario;
    }

    public PreferenciaUsuario(Long id, Categoria categoria, Usuario usuario, Double score) {
        this.id = id;
        this.categoria = categoria;
        this.usuario = usuario;
        this.score = score;
    }

    public PreferenciaUsuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}


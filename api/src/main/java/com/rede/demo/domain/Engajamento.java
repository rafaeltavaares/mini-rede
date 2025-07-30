
package com.rede.demo.domain;

import com.rede.demo.domain.Flags.Taxonomia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Engajamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;

    @Enumerated(EnumType.STRING)
    private Taxonomia taxonomia;

    private LocalDateTime criado_em;

    public Engajamento(Usuario usuario, Postagem postagem, Taxonomia taxonomia ){
        this.usuario = usuario;
        this.postagem = postagem;
        this.taxonomia = taxonomia;
        this.criado_em = LocalDateTime.now();
    }

    public Engajamento() {
    }

    public Engajamento(Long id, Usuario usuario, Postagem postagem, Taxonomia taxonomia, LocalDateTime criado_em) {
        this.id = id;
        this.usuario = usuario;
        this.postagem = postagem;
        this.taxonomia = taxonomia;
        this.criado_em = criado_em;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Taxonomia getTaxonomia() {
        return taxonomia;
    }

    public void setTaxonomia(Taxonomia taxonomia) {
        this.taxonomia = taxonomia;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }
}

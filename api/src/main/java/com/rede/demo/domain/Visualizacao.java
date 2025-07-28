package com.rede.demo.domain;

import com.rede.demo.dtos.Request.CreateVisualizacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Visualizacao {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;

    private LocalDateTime criadoEm;

    public Visualizacao(Usuario usuario, Postagem postagem){
        this.usuario = usuario;
        this.postagem = postagem;
        this.criadoEm = LocalDateTime.now();
    }



}

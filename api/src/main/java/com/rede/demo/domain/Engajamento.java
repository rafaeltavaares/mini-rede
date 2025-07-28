
package com.rede.demo.domain;

import com.rede.demo.domain.Flags.Taxonomia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Engajamento {
    @Id
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
}

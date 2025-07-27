
package com.rede.demo.domain;

import com.rede.demo.domain.Flags.Taxonomia;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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

    private Long user_id;

    private Long post_id;

    @Enumerated(EnumType.STRING)
    private Taxonomia taxonomia;

    private LocalDateTime criado_em;
}

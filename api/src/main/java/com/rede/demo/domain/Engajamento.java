<<<<<<< HEAD
package mini.socialmidia.mini.domain;
=======
package com.rede.demo.domain;
>>>>>>> 9cb1ee8 (build: first look of the system, all essentials classes created)

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
import mini.socialmidia.mini.domain.Flags.Taxonomia;
=======
import com.rede.demo.domain.Flags.Taxonomia;
>>>>>>> 9cb1ee8 (build: first look of the system, all essentials classes created)

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

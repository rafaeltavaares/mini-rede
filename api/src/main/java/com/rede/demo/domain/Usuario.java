package mini.socialmidia.mini.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String senha;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario")
    private List<Amizades> solicitacoesEnviadas;

    @OneToMany(mappedBy = "amigo")
    private List<Amizades> solicitacoesRecebidas;

    private LocalDateTime criado_em;
}

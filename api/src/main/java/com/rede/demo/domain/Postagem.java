package mini.socialmidia.mini.domain;


import jakarta.persistence.*;
import lombok.*;
import mini.socialmidia.mini.domain.Flags.Categoria;
import mini.socialmidia.mini.domain.Flags.Privacidade;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

public class Postagem {

    @Id
    private Long id;

    private String conteudo;

    private String titulo;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Privacidade privacidade;



}

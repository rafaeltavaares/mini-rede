<<<<<<< HEAD
package mini.socialmidia.mini.domain;


=======
package com.rede.demo.domain;


import com.rede.demo.dtos.Request.CreateUsuarioRequestDTO;
>>>>>>> 9cb1ee8 (build: first look of the system, all essentials classes created)
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
<<<<<<< HEAD

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
=======
import java.util.Optional;

@Entity
>>>>>>> 9cb1ee8 (build: first look of the system, all essentials classes created)
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
<<<<<<< HEAD
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario")
    private List<Amizades> solicitacoesEnviadas;

    @OneToMany(mappedBy = "amigo")
    private List<Amizades> solicitacoesRecebidas;

    private LocalDateTime criado_em;
=======
    private List<Amizade> solicitacoesEnviadas;

    @OneToMany(mappedBy = "amigo")
    private List<Amizade> solicitacoesRecebidas;

    private LocalDateTime criado_em;


    public Usuario(CreateUsuarioRequestDTO data){
        this.username = data.username();
        this.email = data.email();
        this.nome = data.nome();
        this.senha = data.senha();
        this.telefone = data.telefone();
        this.criado_em = LocalDateTime.now();

    }

    public Usuario(Long id, String username, String nome, String senha, String email, String telefone, List<Postagem> postagens, List<Amizade> solicitacoesEnviadas, List<Amizade> solicitacoesRecebidas, LocalDateTime criado_em) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.solicitacoesEnviadas = solicitacoesEnviadas;
        this.solicitacoesRecebidas = solicitacoesRecebidas;
        this.criado_em = criado_em;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Amizade> getSolicitacoesEnviadas() {
        return solicitacoesEnviadas;
    }

    public void setSolicitacoesEnviadas(List<Amizade> solicitacoesEnviadas) {
        this.solicitacoesEnviadas = solicitacoesEnviadas;
    }

    public List<Amizade> getSolicitacoesRecebidas() {
        return solicitacoesRecebidas;
    }

    public void setSolicitacoesRecebidas(List<Amizade> solicitacoesRecebidas) {
        this.solicitacoesRecebidas = solicitacoesRecebidas;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }
>>>>>>> 9cb1ee8 (build: first look of the system, all essentials classes created)
}

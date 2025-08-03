package com.rede.demo.repositories;

import com.rede.demo.domain.Amizade;
import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.Flags.Taxonomia;
import com.rede.demo.domain.Postagem;
import com.rede.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EngajamentoRepository extends JpaRepository<Engajamento,Long> {

    Optional<Engajamento> findEngajamentoByUsuarioAndPostagemAndTaxonomia(Usuario usuario, Postagem postagem, Taxonomia taxonomia);
    List<Engajamento> findEngajamentoByUsuarioAndPostagem(Usuario usuario, Postagem postagem);

    List<Engajamento> findEngajamentoByUsuario(Usuario usuario);

    List<Engajamento> findALlEngajamentoByPostagem(Postagem postagem);
}

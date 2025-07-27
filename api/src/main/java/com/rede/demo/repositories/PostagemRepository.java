package com.rede.demo.repositories;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    void deleteAllById(Long idPostagem);

    List<Postagem> findByRespostaAo(Postagem raiz);

    List<Postagem> findByRespostaAoIsNullOrderByCriadoEmDesc();

}

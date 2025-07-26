package com.rede.demo.repositories;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
    
}

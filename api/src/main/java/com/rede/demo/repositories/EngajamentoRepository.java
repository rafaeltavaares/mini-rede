package com.rede.demo.repositories;

import com.rede.demo.domain.Amizade;
import com.rede.demo.domain.Engajamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngajamentoRepository extends JpaRepository<Engajamento,Long> {
    
}

package com.rede.demo.repositories;

import com.rede.demo.domain.Engajamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenciaUsuarioRepository extends JpaRepository<Engajamento,Long> {
    
}

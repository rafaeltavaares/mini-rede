package com.rede.demo.repositories;

import com.rede.demo.domain.Amizade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade,Long> {
    
}

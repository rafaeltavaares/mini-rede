package com.rede.demo.repositories;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.PreferenciaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenciaUsuarioRepository extends JpaRepository<PreferenciaUsuario,Long> {

    @Query("""
    SELECT p.categoria AS categoria, COUNT(p.usuario) AS totalUsuarios
    FROM PreferenciaUsuario p
    WHERE p.score > 0.8
    GROUP BY p.categoria
    ORDER BY totalUsuarios DESC
    """)
    List<PreferenciaUsuario> findCategoriasPopulares();
}

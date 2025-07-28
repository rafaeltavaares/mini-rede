package com.rede.demo.repositories;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.PreferenciaUsuario;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.CategoriaPopularDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenciaUsuarioRepository extends JpaRepository<PreferenciaUsuario,Long> {

    @Query("""
    SELECT new com.rede.demo.dtos.CategoriaPopularDTO(p.categoria, COUNT(p.usuario))
    FROM PreferenciaUsuario p
    WHERE p.score > 0.8
    GROUP BY p.categoria
    ORDER BY COUNT(p.usuario) DESC
    """)
    List<CategoriaPopularDTO> findCategoriasPopulares();

    List<PreferenciaUsuario> findByUsuario(Usuario usuario);
}

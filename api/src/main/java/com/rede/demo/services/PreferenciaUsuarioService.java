package com.rede.demo.services;

import com.rede.demo.domain.PreferenciaUsuario;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.CategoriaPopularDTO;
import com.rede.demo.dtos.Request.CategoriaScoreDTO;
import com.rede.demo.dtos.Request.CreateUsuarioPreferenciaDTO;
import com.rede.demo.dtos.Request.UpdateUsuarioPreferenciaDTO;
import com.rede.demo.repositories.PreferenciaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenciaUsuarioService {

    @Autowired
    private PreferenciaUsuarioRepository repository;

    @Autowired
    private UsuarioService usuarioSerivce;

    public List<PreferenciaUsuario> findAllPreferenciaUsuario(){
        return repository.findAll();
    }

    public void createUsuarioPreferencias(CreateUsuarioPreferenciaDTO data){
        Usuario usuario = usuarioSerivce.ExistUsuarioById(data.usuarioid()).orElseThrow();
        data.preferencias().stream().forEach(preferencia -> repository.save(new PreferenciaUsuario(usuario,preferencia.score(),preferencia.categoria())));
    }

    public List<CategoriaPopularDTO> findMostFamousTopic(){
        return repository.findCategoriasPopulares();
    }
    public void updateUsuarioPreferencias(UpdateUsuarioPreferenciaDTO data) {
        Usuario user = usuarioSerivce.ExistUsuarioById(data.usuarioid()).orElseThrow();
        List<PreferenciaUsuario> preferencesList = repository.findByUsuario(user);

        for (PreferenciaUsuario preferencia : preferencesList) {
            for (CategoriaScoreDTO p : data.preferencias()) {
                if (p.categoria().equals(preferencia.getCategoria())) {
                    preferencia.setScore(p.score());
                }
            }
        }

        repository.saveAll(preferencesList); // Salva as alterações no banco

    }
    //public PreferenciaUsuario highestPreferenciaScoreToUser(){}

    //public PreferenciaUsuario
}

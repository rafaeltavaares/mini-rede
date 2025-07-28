package com.rede.demo.services;

import com.rede.demo.domain.PreferenciaUsuario;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreateUsuarioPreferenciaDTO;
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

    //public PreferenciaUsuario findMostFamousTopic(){}



    //public PreferenciaUsuario updateUsuarioPreferencias(){}

    //public PreferenciaUsuario highestPreferenciaScoreToUser(){}

    //public PreferenciaUsuario
}

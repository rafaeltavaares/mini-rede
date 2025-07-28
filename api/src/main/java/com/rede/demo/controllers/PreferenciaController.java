package com.rede.demo.controllers;

import com.rede.demo.domain.PreferenciaUsuario;
import com.rede.demo.dtos.CategoriaPopularDTO;
import com.rede.demo.dtos.Request.CreateUsuarioPreferenciaDTO;
import com.rede.demo.dtos.Request.UpdateUsuarioPreferenciaDTO;
import com.rede.demo.dtos.UsuarioCategoriaScore;
import com.rede.demo.services.PreferenciaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario/preferencias")
public class PreferenciaController {

    @Autowired
    private PreferenciaUsuarioService service;

    @GetMapping
    public ResponseEntity<List<PreferenciaUsuario>> findAllPreferencias(){
        List<PreferenciaUsuario> preferencias = service.findAllPreferenciaUsuario();
        return new ResponseEntity<>(preferencias,HttpStatus.OK);
    }

    @PostMapping
    public void createUsuarioPreferencias(@RequestBody CreateUsuarioPreferenciaDTO data){
      service.createUsuarioPreferencias(data);
    }

    @GetMapping("/top")
    public ResponseEntity<List<CategoriaPopularDTO>> findTopCategorias(){
        List<CategoriaPopularDTO> preferencias = service.findMostFamousTopic();
        return new ResponseEntity<>(preferencias,HttpStatus.OK);
    }

    @PutMapping("/update")
    public void UpdateUserPreferences(@RequestBody UpdateUsuarioPreferenciaDTO data){
        service.updateUsuarioPreferencias(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UsuarioCategoriaScore>> findUserTopCategorias(@PathVariable Long id){
        List<UsuarioCategoriaScore> preferencias = service.highestsPreferenciaScoreToUser(id);
        return new ResponseEntity<>(preferencias,HttpStatus.OK);
    }
}

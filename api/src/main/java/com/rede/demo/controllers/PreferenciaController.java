package com.rede.demo.controllers;

import com.rede.demo.domain.PreferenciaUsuario;
import com.rede.demo.dtos.Request.CreateUsuarioPreferenciaDTO;
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
}

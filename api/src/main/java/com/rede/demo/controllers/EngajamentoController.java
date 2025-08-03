package com.rede.demo.controllers;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.dtos.Request.CreateEngajamentoDTO;
import com.rede.demo.dtos.Response.MessageDTO;
import com.rede.demo.dtos.Response.PostagemTaxonomiaDTO;
import com.rede.demo.services.EngajamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engajamento")
public class EngajamentoController {

    @Autowired
    private EngajamentoService service;

    @PutMapping
    public void createEngajamento(@RequestBody CreateEngajamentoDTO data){
        service.createEngajamento(data);
    }

    @GetMapping
    public ResponseEntity<List<Engajamento>> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/likes/{id}")
    public ResponseEntity<List<PostagemTaxonomiaDTO>> findUsuarioLikes(@PathVariable Long id){
        List<PostagemTaxonomiaDTO> likes = service.findEngajamentoLikeByUsuario(id);
        return new ResponseEntity<>(likes,HttpStatus.OK);
    }

    @GetMapping("/compartilhamento/{id}")
    public ResponseEntity<List<PostagemTaxonomiaDTO>> findUsuarioCompartilhamentos(@PathVariable Long id){
        List<PostagemTaxonomiaDTO> likes = service.findEngajamentoShareByUsuario(id);
        return new ResponseEntity<>(likes,HttpStatus.OK);
    }

    @GetMapping("/salvos/{id}")
    public ResponseEntity<List<PostagemTaxonomiaDTO>> findUsuarioSalvos(@PathVariable Long id){
        List<PostagemTaxonomiaDTO> likes = service.findEngajamentoShareByUsuario(id);
        return new ResponseEntity<>(likes,HttpStatus.OK);
    }

}

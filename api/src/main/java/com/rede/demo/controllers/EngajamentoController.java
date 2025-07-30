package com.rede.demo.controllers;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.dtos.Request.CreateEngajamentoDTO;
import com.rede.demo.dtos.Response.MessageDTO;
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

}

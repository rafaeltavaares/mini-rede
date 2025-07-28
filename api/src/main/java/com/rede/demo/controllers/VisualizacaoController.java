package com.rede.demo.controllers;


import com.rede.demo.domain.Visualizacao;
import com.rede.demo.dtos.Request.CreateVisualizacaoDTO;
import com.rede.demo.services.VisualizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visualizacao")
public class VisualizacaoController {

    @Autowired
    private VisualizacaoService service;

    @PostMapping
    public ResponseEntity<Visualizacao> createVisualizacao(@RequestBody CreateVisualizacaoDTO visualizacao){
        Visualizacao view = service.createView(visualizacao);
        return new ResponseEntity<>(view, HttpStatus.OK);
    }


}

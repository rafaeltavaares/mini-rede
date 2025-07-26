package com.rede.demo.controllers;


import com.rede.demo.domain.Postagem;
import com.rede.demo.dtos.Request.CreatePostagemRequestDTO;
import com.rede.demo.services.PostagemService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/postagem")
public class PostagemController {

    @Autowired
    private PostagemService service;

    @PostMapping
    public ResponseEntity<Postagem> create(@RequestBody CreatePostagemRequestDTO data) throws Exception {
        Postagem postagem = service.createPostagem(data);
        return new ResponseEntity<>(postagem, HttpStatus.CREATED);
    }
}

package com.rede.demo.controllers;


import com.rede.demo.domain.Postagem;
import com.rede.demo.dtos.Request.CreatePostagemRequestDTO;
import com.rede.demo.dtos.Response.ViewPostagemCompletaDTO;
import com.rede.demo.dtos.Response.ViewPostagemDTO;
import com.rede.demo.repositories.PostagemRepository;
import com.rede.demo.services.PostagemService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/postagem")
public class PostagemController {

    @Autowired
    private PostagemService service;

    @Autowired
    private PostagemRepository repository;

    @PostMapping
    public ResponseEntity<Postagem> create(@RequestBody CreatePostagemRequestDTO data) throws Exception {
        Postagem postagem = service.createPostagem(data);
        return new ResponseEntity<>(postagem, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ViewPostagemDTO>> listarPostagensDeTopo() {
        List<Postagem> raizes = repository.findByRespostaAoIsNullOrderByCriadoEmDesc(); // mudar depois
        List<ViewPostagemDTO> dtos = raizes.stream()
                .map(ViewPostagemDTO::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}/comentarios")
    public ResponseEntity<ViewPostagemCompletaDTO> verThread(@PathVariable Long id) {
        Postagem postagem = repository.findById(id).orElseThrow();

        // Subir até a raiz, se não for
        while (postagem.getResposta_ao() != null) {
            postagem = postagem.getResposta_ao();
        }

        ViewPostagemCompletaDTO thread = service.montarThread(postagem);
        return ResponseEntity.ok(thread);
    }


}

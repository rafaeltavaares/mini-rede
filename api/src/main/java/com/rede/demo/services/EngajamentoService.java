package com.rede.demo.services;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.Flags.Taxonomia;
import com.rede.demo.domain.Postagem;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreateEngajamentoDTO;
import com.rede.demo.dtos.Response.MessageDTO;
import com.rede.demo.repositories.EngajamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EngajamentoService {
    @Autowired
    private EngajamentoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostagemService postagemService;

    private void saveEngajamento(Usuario usuario, Postagem postagem, Taxonomia taxonomia){
        Engajamento novoEngajamento = new Engajamento(usuario,postagem,taxonomia);
        repository.save(novoEngajamento);
    }

    public void createEngajamento(Engajamento engajamento){
        repository.save(engajamento);
    }

    public List<Engajamento> findAll(){
        return repository.findAll();
    }

    public void createEngajamento(CreateEngajamentoDTO data){

        Postagem postagem = postagemService.findPostagemById(data.postagemId())
                .orElseThrow();

        Usuario usuario = usuarioService.ExistUsuarioById(data.usuarioId())
                .orElseThrow();

        Optional<Engajamento> engajamentoOptional = repository
                .findEngajamentoByUsuarioAndPostagemAndTaxonomia(usuario, postagem, data.taxonomia());

        if (engajamentoOptional.isPresent()) {
            Engajamento engajamento = engajamentoOptional.get();
            engajamento.setTaxonomia(null);
            repository.save(engajamento);
        } else {
            Engajamento novoEngajamento = new Engajamento(usuario, postagem, data.taxonomia());
            repository.save(novoEngajamento);
        }

    }




}

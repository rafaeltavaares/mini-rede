package com.rede.demo.services;

import com.rede.demo.domain.Engajamento;
import com.rede.demo.domain.Flags.Taxonomia;
import com.rede.demo.domain.Postagem;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreateEngajamentoDTO;
import com.rede.demo.dtos.Response.PostagemTaxonomiaDTO;
import com.rede.demo.repositories.EngajamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EngajamentoService {
    @Autowired
    private EngajamentoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostagemService postagemService;

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

    private List<PostagemTaxonomiaDTO> findEngajamentoByUsuario(Long usuarioId, Taxonomia filtroTaxonomia){
        Usuario usuario = usuarioService.ExistUsuarioById(usuarioId)
                .orElseThrow();

        // 1. Buscar TODOS os engajamentos do usuário (não filtrando pela taxonomia ainda)
        List<Engajamento> todosEngajamentos = repository.findEngajamentoByUsuario(usuario);

        if (todosEngajamentos.isEmpty()) {
            throw new RuntimeException("Usuário não tem nenhum engajamento.");
        }

        // 2. Encontrar as postagens que ele engajou com a taxonomia FILTRADA (ex: LIKE)
        Set<Postagem> postagensComFiltro = todosEngajamentos.stream()
                .filter(e -> e.getTaxonomia().equals(filtroTaxonomia))
                .map(Engajamento::getPostagem)
                .collect(Collectors.toSet());

        // 3. Para essas postagens, coletar todos os engajamentos (de qualquer tipo)
        Map<Postagem, List<Taxonomia>> mapaPostagemTaxonomias = new HashMap<>();

        for (Engajamento eng : todosEngajamentos) {
            Postagem postagem = eng.getPostagem();

            if (postagensComFiltro.contains(postagem)) {
                mapaPostagemTaxonomias
                        .computeIfAbsent(postagem, p -> new ArrayList<>())
                        .add(eng.getTaxonomia());
            }
        }

        // 4. Montar os DTOs
        return mapaPostagemTaxonomias.entrySet().stream()
                .map(entry -> new PostagemTaxonomiaDTO(entry.getKey(), entry.getValue()))
                .toList();
    }


    public List<PostagemTaxonomiaDTO> findEngajamentoLikeByUsuario(Long usuarioId){
        return findEngajamentoByUsuario(usuarioId,Taxonomia.LIKE);
    }

    public List<PostagemTaxonomiaDTO> findEngajamentoShareByUsuario(Long usuarioId){
        return findEngajamentoByUsuario(usuarioId,Taxonomia.COMPARTILHAMENTO);
    }

    public List<PostagemTaxonomiaDTO> findEngajamentoSalvosByUsuario(Long usuarioId){
        return findEngajamentoByUsuario(usuarioId,Taxonomia.FAVORITOS);
    }







}

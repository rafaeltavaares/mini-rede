package com.rede.demo.services;

import com.rede.demo.domain.Postagem;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreatePostagemRequestDTO;
import com.rede.demo.dtos.Response.MessageDTO;
import com.rede.demo.dtos.Response.ViewPostagemCompletaDTO;
import com.rede.demo.repositories.PostagemRepository;
import com.rede.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Optional<Postagem> findPostagemById(Long id){
        return repository.findById(id);
    }


    public ViewPostagemCompletaDTO montarThread(Postagem raiz) {

        ViewPostagemCompletaDTO dto = new ViewPostagemCompletaDTO(raiz);

        List<Postagem> respostas = repository.findByRespostaAo(raiz);

        List<ViewPostagemCompletaDTO> respostasDTO = respostas.stream()
                .map(this::montarThread)
                .toList();

        return dto.withRespostas(respostasDTO);
    }

    public Postagem createPostagem(CreatePostagemRequestDTO data) throws Exception {
        Usuario usuario = usuarioRepository.findById(data.usuario().id())
                .orElseThrow(() -> new RuntimeException("This user do not exist"));

        if(data.respostaAo() != null){
            Postagem raiz = repository.findById(data.respostaAo()).orElseThrow();
            Postagem postagem = new Postagem(data,usuario,raiz);
            repository.save(postagem);

            return postagem;
        }
        Postagem postagem = new Postagem(data,usuario);

        repository.save(postagem);

        return postagem;
    }

    public MessageDTO deletePostagem(Long idPostagem){

        repository.deleteAllById(idPostagem);

        return new MessageDTO("Sucess");
    }



}

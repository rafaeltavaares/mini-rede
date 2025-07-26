package com.rede.demo.services;

import com.rede.demo.domain.Postagem;
import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreatePostagemRequestDTO;
import com.rede.demo.repositories.PostagemRepository;
import com.rede.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Postagem createPostagem(CreatePostagemRequestDTO data) throws Exception {
        Usuario usuario = usuarioRepository.findById(data.usuario().id())
                .orElseThrow(() -> new RuntimeException("This user do not exist"));
        Postagem postagem = new Postagem(data,usuario);
        repository.save(postagem);
        return postagem;
    }



}

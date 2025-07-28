package com.rede.demo.services;


import com.rede.demo.domain.Postagem;
import com.rede.demo.domain.Usuario;
import com.rede.demo.domain.Visualizacao;
import com.rede.demo.dtos.Request.CreateVisualizacaoDTO;
import com.rede.demo.repositories.VisualizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisualizacaoService {

    @Autowired
    private VisualizacaoRepository repository;

    @Autowired
    private PostagemService postagemService;

    @Autowired
    private UsuarioService usuarioService;

    public Visualizacao createView(CreateVisualizacaoDTO data){
        Usuario usuario = usuarioService.ExistUsuarioById(data.usuarioID()).orElseThrow();

        Postagem postagem = postagemService.findPostagemById(data.postagemID()).orElseThrow();

        Visualizacao view = new Visualizacao(usuario,postagem);
        repository.save(view);
        return view;
    }

}

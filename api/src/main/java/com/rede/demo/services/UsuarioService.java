package com.rede.demo.services;

import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreateUsuarioRequestDTO;
import com.rede.demo.dtos.Response.MessageDTO;
import com.rede.demo.dtos.Response.UsuarioResponseDTO;
import com.rede.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Optional<Usuario> ExistUsuarioById(Long id){
        return repository.findById(id);
    }

    public List<UsuarioResponseDTO> findAll(){
        List<Usuario> users = repository.findAll();
        return users.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    public UsuarioResponseDTO createUser(CreateUsuarioRequestDTO data) throws Exception {
        if(repository.findByUsername(data.username()).isPresent()){
            throw new Exception("Username already taken");
        }
        if(repository.findByEmail(data.email()).isPresent()){
            throw new Exception("E-mail already registerd");
        }
        Usuario newUsuario = new Usuario(data);
        repository.save(newUsuario);
        return new UsuarioResponseDTO(newUsuario.getUsername(),newUsuario.getEmail(), newUsuario.getNome(), newUsuario.getTelefone(), newUsuario.getCriado_em() );
    }

    public MessageDTO deleteUser(String username) throws Exception {
        Usuario user = repository.findByUsername(username).orElseThrow( () -> new Exception("User not found"));
        repository.delete(user);
        return new MessageDTO("Usuario deletado permanentemente");
    }


}

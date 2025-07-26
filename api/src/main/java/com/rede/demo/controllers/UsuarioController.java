package com.rede.demo.controllers;

import com.rede.demo.domain.Usuario;
import com.rede.demo.dtos.Request.CreateUsuarioRequestDTO;
import com.rede.demo.dtos.Response.MessageDTO;
import com.rede.demo.dtos.Response.UsuarioResponseDTO;
import com.rede.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> FindAllUsers(){
        List<UsuarioResponseDTO> usuarioResponseDTOresponse = service.findAll();
        return new ResponseEntity<>(usuarioResponseDTOresponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUser(@RequestBody CreateUsuarioRequestDTO data) throws Exception {
        UsuarioResponseDTO newUsuario = service.createUser(data);
        return new ResponseEntity<>(newUsuario,HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<MessageDTO> deteleUser(@RequestParam String username ) throws Exception {
        MessageDTO message = service.deleteUser(username);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }


}

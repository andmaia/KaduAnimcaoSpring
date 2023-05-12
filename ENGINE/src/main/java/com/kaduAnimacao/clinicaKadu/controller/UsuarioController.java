package com.kaduAnimacao.clinicaKadu.controller;


import com.kaduAnimacao.clinicaKadu.DTO.AutenticacaoDTO;
import com.kaduAnimacao.clinicaKadu.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid AutenticacaoDTO dados){
        var usuario = usuarioService.cadastrarUsuario(dados);
        return ResponseEntity.ok().body(usuario.getSenha());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok().body(usuario);
    }
}

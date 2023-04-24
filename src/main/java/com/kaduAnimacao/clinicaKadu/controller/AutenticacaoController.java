package com.kaduAnimacao.clinicaKadu.controller;

import com.kaduAnimacao.clinicaKadu.DTO.AutenticacaoDTO;
import com.kaduAnimacao.clinicaKadu.infra.security.TokenService;
import com.kaduAnimacao.clinicaKadu.models.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados){
      var token = new UsernamePasswordAuthenticationToken(dados.login()
      ,dados.senha());
      var authentication =   authenticationManager.authenticate(token);
      return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
    }

}

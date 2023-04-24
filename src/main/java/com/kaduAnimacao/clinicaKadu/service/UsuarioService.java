package com.kaduAnimacao.clinicaKadu.service;

import com.kaduAnimacao.clinicaKadu.DTO.AutenticacaoDTO;
import com.kaduAnimacao.clinicaKadu.models.Usuario;
import com.kaduAnimacao.clinicaKadu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Usuario cadastrarUsuario(AutenticacaoDTO dados){
    var senhaHash = passwordEncoder.encode(dados.senha());
    var usuario = new Usuario(null, dados.login(), senhaHash);
    usuarioRepository.save(usuario);
    return usuario;
    }

    public AutenticacaoDTO getUsuarioById(Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return new AutenticacaoDTO(usuario);
    }


}

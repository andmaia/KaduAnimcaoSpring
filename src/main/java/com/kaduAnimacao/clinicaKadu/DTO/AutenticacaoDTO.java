package com.kaduAnimacao.clinicaKadu.DTO;

import com.kaduAnimacao.clinicaKadu.models.Usuario;

public record AutenticacaoDTO(
        String login,
        String senha
) {
    public AutenticacaoDTO(Usuario usuario){
        this(usuario.getLogin(),usuario.getSenha());
    }
}

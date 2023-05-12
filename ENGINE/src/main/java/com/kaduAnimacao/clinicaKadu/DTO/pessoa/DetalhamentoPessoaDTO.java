package com.kaduAnimacao.clinicaKadu.DTO.pessoa;

import com.kaduAnimacao.clinicaKadu.models.Pessoa;

import java.util.Date;

public record DetalhamentoPessoaDTO(
        Long id,
        String nome,
        Date dataNascimento,
        String telefone,
        String endereco
) {
    public  DetalhamentoPessoaDTO(Pessoa pessoa){
        this(pessoa.getId(),pessoa.getNome(),pessoa.getDataNascimento(),pessoa.getTelefone(),pessoa.getEndereco());
    }
}

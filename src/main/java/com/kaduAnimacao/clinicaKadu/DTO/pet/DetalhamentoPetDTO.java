package com.kaduAnimacao.clinicaKadu.DTO.pet;

import com.kaduAnimacao.clinicaKadu.DTO.pessoa.DetalhamentoPessoaDTO;
import com.kaduAnimacao.clinicaKadu.models.Pessoa;
import com.kaduAnimacao.clinicaKadu.models.Pet;

import java.util.Date;

public record DetalhamentoPetDTO(
        Long id,
        String nome,
        Date dataNascimento,
        String raça,
        DetalhamentoPessoaDTO detalhamentoPessoaDTO
) {
    public DetalhamentoPetDTO(Pet pet){
        this(pet.getId(),pet.getNome(),pet.getDataNascimento(),pet.getRaca(),new DetalhamentoPessoaDTO(pet.getPessoa()));
    }

}

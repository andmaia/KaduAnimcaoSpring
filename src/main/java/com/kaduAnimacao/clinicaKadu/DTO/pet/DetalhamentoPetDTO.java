package com.kaduAnimacao.clinicaKadu.DTO.pet;

import com.kaduAnimacao.clinicaKadu.models.Pet;

import java.util.Date;

public record DetalhamentoPetDTO(
        Long id,
        String nome,
        Date dataNascimento,
        String raça,
        Long pessoa
) {
    public DetalhamentoPetDTO(Pet pet){
        this(pet.getId(),pet.getNome(),pet.getDataNascimento(),pet.getRaca(),pet.getPessoa().getId());
    }

}

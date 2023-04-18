package com.kaduAnimacao.clinicaKadu.DTO.pet;

public record AtualizarPetDTO(
        Long id,
        String nome,
        String dataNascimento,
        String raça,
        Long pessoa
) {
}

package com.kaduAnimacao.clinicaKadu.DTO.pet;

import jakarta.validation.constraints.Pattern;

public record AtualizarPetDTO(
        Long id,
        String nome,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato de data inválido. O formato deve ser dd/MM/yyyy.")
        String dataNascimento,
        String raça,
        Long pessoa
) {
}

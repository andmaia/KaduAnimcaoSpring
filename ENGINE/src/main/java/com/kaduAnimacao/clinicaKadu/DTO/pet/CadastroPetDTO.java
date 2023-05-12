package com.kaduAnimacao.clinicaKadu.DTO.pet;

import com.kaduAnimacao.clinicaKadu.models.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroPetDTO(
        @NotBlank
        @NotNull(message = "O nome não pode ser nulo.")
        String nome,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato de data inválido. O formato deve ser dd/MM/yyyy.")
        String dataNascimento,
        @NotBlank(message = "A raça do pet não pode ser nula.")
        String raça,
        @NotNull(message = "O pede precisa pertencer a alguem dono.")
        Long pessoa
) {
}

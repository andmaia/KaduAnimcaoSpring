package com.kaduAnimacao.clinicaKadu.DTO.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroPessoaDTO(
        Long id,
        @NotNull
        @NotBlank(message = "O nome da pessoa não pode ser nulo")
        String nome,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato de data inválido. O formato deve ser dd/MM/yyyy.")
        String dataNascimento,
        String telefone,
        String endereco

) {
}

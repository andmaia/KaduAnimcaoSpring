package com.kaduAnimacao.clinicaKadu.DTO.pessoa;

import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record AtualizaPessoaDTO(
        Long id,
        String nome,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato de data inválido. O formato deve ser dd/MM/yyyy.")
        String dataNascimento,
        String telefone,
        String endereco
) {
}

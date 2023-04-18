package com.kaduAnimacao.clinicaKadu.DTO.pessoa;

import java.util.Date;

public record AtualizaPessoaDTO(
        Long id,
        String nome,
        String dataNascimento,
        String telefone,
        String endereco
) {
}

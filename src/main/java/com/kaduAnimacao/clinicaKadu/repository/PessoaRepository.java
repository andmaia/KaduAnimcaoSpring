package com.kaduAnimacao.clinicaKadu.repository;

import com.kaduAnimacao.clinicaKadu.models.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Page<Pessoa> findAllByStatusTrue(org.springframework.data.domain.Pageable pageable);
}

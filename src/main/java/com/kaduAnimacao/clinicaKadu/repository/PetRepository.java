package com.kaduAnimacao.clinicaKadu.repository;

import com.kaduAnimacao.clinicaKadu.models.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
    Page<Pet> findAllByStatusTrue(Pageable pageable);
}

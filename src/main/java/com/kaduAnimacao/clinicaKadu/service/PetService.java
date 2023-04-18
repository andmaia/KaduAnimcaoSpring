package com.kaduAnimacao.clinicaKadu.service;

import com.kaduAnimacao.clinicaKadu.DTO.pet.AtualizarPetDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pet.CadastroPetDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pet.DetalhamentoPetDTO;
import com.kaduAnimacao.clinicaKadu.models.Pessoa;
import com.kaduAnimacao.clinicaKadu.models.Pet;
import com.kaduAnimacao.clinicaKadu.repository.PessoaRepository;
import com.kaduAnimacao.clinicaKadu.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<DetalhamentoPetDTO> listarTodosOsPets(Pageable pageable){
        var page = petRepository.findAllByStatusTrue(pageable).map(DetalhamentoPetDTO::new);
        return page;
    }

    public Pet listarPorId(Long id){
        var pet = petRepository.getReferenceById(id);
        return pet;
    }

    public Pet cadastrarPet(CadastroPetDTO dadosCadastroPet){
        var pessoa = pessoaRepository.getReferenceById(dadosCadastroPet.pessoa());
        var pet=new Pet(dadosCadastroPet,pessoa);
        petRepository.save(pet);
        return pet;
    }

    public Pet atualizarPet(AtualizarPetDTO dadosAtualizacaoPet){
        Pessoa pessoa=null;
        if(dadosAtualizacaoPet.pessoa()!=null){
            pessoa=pessoaRepository.getReferenceById(dadosAtualizacaoPet.pessoa());
        }
        var pet = petRepository.getReferenceById(dadosAtualizacaoPet.id());
        pet.atualizar(dadosAtualizacaoPet,pessoa);
        return pet;
    }

    public void deletarPet(Long id){
        var pet = petRepository.getReferenceById(id);
        pet.deletar();
    }


}

package com.kaduAnimacao.clinicaKadu.controller;


import com.kaduAnimacao.clinicaKadu.DTO.pet.AtualizarPetDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pet.CadastroPetDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pet.DetalhamentoPetDTO;
import com.kaduAnimacao.clinicaKadu.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    @Transactional
    public ResponseEntity create (@RequestBody @Valid CadastroPetDTO dadosCadastroPet, UriComponentsBuilder uriComponentsBuilder){
        var pet =petService.cadastrarPet(dadosCadastroPet);
        var uri=uriComponentsBuilder.path("/{id}").buildAndExpand(pet.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPetDTO(pet));

    }

    @GetMapping("/{id}")
    public ResponseEntity getPet(@PathVariable Long id){
        var pet=petService.listarPorId(id);
        return  ResponseEntity.ok(new DetalhamentoPetDTO(pet));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhamentoPetDTO> > getAllPet(@PageableDefault(size=3,sort={"nome"},page = 1) Pageable pageable){
        var pets = petService.listarTodosOsPets(pageable);
        return ResponseEntity.ok(pets);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoPetDTO> atualizarPet(@RequestBody @Valid AtualizarPetDTO atualizarPetDTO){
        var pet =petService.atualizarPet(atualizarPetDTO);
        return ResponseEntity.ok(new DetalhamentoPetDTO(pet));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPet(@PathVariable Long id){
        petService.deletarPet(id);
        return ResponseEntity.noContent().build();

    }


}

package com.kaduAnimacao.clinicaKadu.controller;


import com.kaduAnimacao.clinicaKadu.DTO.pessoa.AtualizaPessoaDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pessoa.CadastroPessoaDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pessoa.DetalhamentoPessoaDTO;
import com.kaduAnimacao.clinicaKadu.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value= "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping()
    @Transactional
    public ResponseEntity cadastrarPessoa(@RequestBody @Valid CadastroPessoaDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var pessoa = pessoaService.insert(dados);
        var uri = uriComponentsBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalhamentoPessoaDTO(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPessoa(@PathVariable Long id){
        var pessoa = pessoaService.encontrarPorId(id);
        return ResponseEntity.ok().body(new DetalhamentoPessoaDTO(pessoa));
    }

    @GetMapping
    public ResponseEntity listarPessoas(@PageableDefault(size=3,sort={"nome"},page = 1)Pageable pageable){
        var pessoas = pessoaService.listarTodos(pageable);
        return  ResponseEntity.ok(pessoas);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPessoa(@RequestBody  AtualizaPessoaDTO dados){
        var pessoa = pessoaService.atualizar(dados);
        return  ResponseEntity.ok().body(new DetalhamentoPessoaDTO(pessoa));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPessoa(@PathVariable Long id){
        var pessoa = pessoaService.encontrarPorId(id);
        pessoa.excluir();
        return ResponseEntity.noContent().build();
    }




}

package com.kaduAnimacao.clinicaKadu.service;


import com.kaduAnimacao.clinicaKadu.DTO.pessoa.AtualizaPessoaDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pessoa.CadastroPessoaDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pessoa.DetalhamentoPessoaDTO;
import com.kaduAnimacao.clinicaKadu.models.Pessoa;
import com.kaduAnimacao.clinicaKadu.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<DetalhamentoPessoaDTO> listarTodos(Pageable pageable){
            var page = pessoaRepository.findAllByStatusTrue(pageable).map(DetalhamentoPessoaDTO::new);
            return page;
    }

    public  Pessoa encontrarPorId(Long id){
        Pessoa pessoa= pessoaRepository.getReferenceById(id);
        return pessoa;
    }

    public Pessoa insert(CadastroPessoaDTO dados)  {
        Pessoa pessoa = new Pessoa(dados);
        pessoaRepository.save(pessoa);
        return pessoa;

    }

    public void delete(Long id) {
        var pessoa = pessoaRepository.getReferenceById(id);
        pessoa.excluir();
    }

    public Pessoa atualizar(AtualizaPessoaDTO dados){
        Pessoa pessoa = pessoaRepository.getReferenceById(dados.id());
        pessoa.atualizarAtributos(dados);
        return pessoa;
    }



}

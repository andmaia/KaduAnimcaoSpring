package com.kaduAnimacao.clinicaKadu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaduAnimacao.clinicaKadu.DTO.pessoa.AtualizaPessoaDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pessoa.CadastroPessoaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="TB_PESSOA")
@Entity(name="Pessoa")
@Data
@NoArgsConstructor

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nm_pessoa")
    private String nome;
    @Column(name="dt_nascimento")
    private Date dataNascimento;
    @Column(name="nr_telefone")
    private String telefone;
    @Column(name="ds_endereco")
    private String endereco;
    @Column(name="st_pessoa")
    private boolean status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pessoa")
    private List<Pet> pets = new ArrayList<Pet>();



    public void atualizarAtributos(AtualizaPessoaDTO dadosPessoaDTO){
        if(dadosPessoaDTO.nome()!=null){
            this.nome=dadosPessoaDTO.nome();
        }
        if(dadosPessoaDTO.dataNascimento()!=null){
            this.dataNascimento=Pet.mudarStringParaData(dadosPessoaDTO.dataNascimento());
        }
        if(dadosPessoaDTO.endereco()!=null){
            this.endereco=dadosPessoaDTO.endereco();
        }
        if(dadosPessoaDTO.telefone()!=null){
            this.telefone=dadosPessoaDTO.telefone();
        }

    }

    public Pessoa(CadastroPessoaDTO dadosDTO){
        this.id=dadosDTO.id();
        this.nome=dadosDTO.nome();
        this.endereco=dadosDTO.endereco();
        this.dataNascimento=Pet.mudarStringParaData(dadosDTO.dataNascimento());
        this.telefone=dadosDTO.telefone();
        this.status=true;
    }

    public void excluir() {
        this.status=false;
    }
}

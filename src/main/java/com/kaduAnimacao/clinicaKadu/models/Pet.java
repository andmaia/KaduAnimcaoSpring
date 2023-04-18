package com.kaduAnimacao.clinicaKadu.models;

import com.kaduAnimacao.clinicaKadu.DTO.pet.AtualizarPetDTO;
import com.kaduAnimacao.clinicaKadu.DTO.pet.CadastroPetDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name="TB_PET")
@Entity(name="Pet")
@Data
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nm_pet")
    private  String nome;
    @Column(name="dt_nascimento")
    private Date dataNascimento;
    @Column(name="ds_raca")
    private String raca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @Column(name="st_pet")
    private boolean status;


    public Pet(CadastroPetDTO dadosCadastroPetDTO,Pessoa pessoa){
        this.id=null;
        this.nome=dadosCadastroPetDTO.nome();
        this.raca=dadosCadastroPetDTO.raça();
        this.dataNascimento=mudarStringParaData(dadosCadastroPetDTO.dataNascimento());
        this.pessoa=pessoa;
        this.status=true;
    }

    public void atualizar (AtualizarPetDTO dadosAtualizarPet,Pessoa pessoa){
        if(dadosAtualizarPet.nome()!=null){
            this.nome=dadosAtualizarPet.nome();
        }
        if(dadosAtualizarPet.dataNascimento()!=null){
            this.dataNascimento=mudarStringParaData(dadosAtualizarPet.dataNascimento());
        }
        if(dadosAtualizarPet.pessoa()!=null){
            this.pessoa=pessoa;
        }
        if(dadosAtualizarPet.raça()!=null){
            this.raca=dadosAtualizarPet.raça();
        }
    }


    public static Date mudarStringParaData(String dataString) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = format.parse(dataString);
        } catch (Exception exception) {
            throw new RuntimeException("Não foi possível trnaformar em data");
        }

        return data;
    }

    public void deletar(){
        this.status=false;
    }


}

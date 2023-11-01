package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Endereco;
import com.luis.trabalhoPweb.entities.Especialidade;
import com.luis.trabalhoPweb.entities.Medico;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class MedicoPutDTO {


    private String nome;
    private String telefone;
    private Endereco endereco;

    public MedicoPutDTO(Medico entidade) {
        this.nome = entidade.getNome();
        this.telefone = entidade.getTelefone();
        this.endereco = entidade.getEndereco();
    }

}



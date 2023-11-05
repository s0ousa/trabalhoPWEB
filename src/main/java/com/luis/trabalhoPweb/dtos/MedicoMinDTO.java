package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Especialidade;
import com.luis.trabalhoPweb.entities.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoMinDTO {

    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

    public MedicoMinDTO(Medico entidade) {
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.crm = entidade.getCrm();
        this.especialidade = entidade.getEspecialidade();
    }
}

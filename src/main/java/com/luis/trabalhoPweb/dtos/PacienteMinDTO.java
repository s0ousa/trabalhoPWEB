package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Medico;
import com.luis.trabalhoPweb.entities.Paciente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteMinDTO {

    private Long id;
    private String nome;
    private String email;
    private String cpf;

    public PacienteMinDTO(Paciente entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.cpf = entidade.getCpf();
    }

}

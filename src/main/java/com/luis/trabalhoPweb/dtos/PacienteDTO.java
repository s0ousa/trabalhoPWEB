package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Endereco;
import com.luis.trabalhoPweb.entities.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
public class PacienteDTO {


    private Long id;
    @NotBlank(message = "Nome não pode estar em branco.")
    private String nome;
    @NotBlank
    @Email(message = "Endereço de email inválido.")
    private String email;
    @NotBlank (message = "Telefone não pode estar em branco.")
    private String telefone;
    @NotBlank @CPF (message = "CPF não pode estar em branco.")
    private String cpf;

//    @Valid
//    @NotBlank (message = "Endereco não pode estar em branco.")
    private Endereco endereco;
    private Boolean ativo = true;


    public PacienteDTO() {
    }

    public PacienteDTO(Long id, String nome, String email, String telefone, String cpf, Endereco endereco, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = ativo;

    }

    public PacienteDTO(Paciente entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.telefone = entidade.getTelefone();
        this.cpf = entidade.getCpf();
        this.endereco = entidade.getEndereco();
        this.ativo = entidade.getAtivo();
    }
}

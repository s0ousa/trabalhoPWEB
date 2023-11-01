package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Endereco;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Data
public class PacienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    private String cpf;
    private Endereco endereco;
    private Boolean ativo;


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
}

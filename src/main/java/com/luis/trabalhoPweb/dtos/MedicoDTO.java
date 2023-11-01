package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Endereco;
import com.luis.trabalhoPweb.entities.Especialidade;
import com.luis.trabalhoPweb.entities.Medico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class MedicoDTO {

    private Long id;
    @NotBlank(message = "Nome não pode estar em branco.")
    private String nome;
    @NotBlank @Email(message = "Endereço de email inválido.")
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String crm;
    @NotBlank
    private Especialidade especialidade;
    @NotBlank
    private Endereco endereco;
    private Boolean ativo;

    public MedicoDTO() {
    }

    public MedicoDTO(Long id,String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public MedicoDTO(Medico entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.telefone = entidade.getTelefone();
        this.crm = entidade.getCrm();
        this.especialidade = entidade.getEspecialidade();
        this.endereco = entidade.getEndereco();
        this.ativo = entidade.getAtivo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Medico converte(MedicoDTO medicoDTO) {
        return new Medico(medicoDTO);
    }
}

package com.luis.trabalhoPweb.dtos;

import com.luis.trabalhoPweb.entities.Endereco;
import com.luis.trabalhoPweb.entities.Especialidade;
import com.luis.trabalhoPweb.entities.Medico;



public class MedicoDTO {

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    private Especialidade especialidade;
    private Endereco endereco;

    public MedicoDTO() {
    }

    public MedicoDTO(String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public MedicoDTO(Medico entidade) {
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.telefone = entidade.getTelefone();
        this.crm = entidade.getCrm();
        this.especialidade = entidade.getEspecialidade();
        this.endereco = entidade.getEndereco();
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

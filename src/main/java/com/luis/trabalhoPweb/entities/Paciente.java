package com.luis.trabalhoPweb.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;


@Data
@Entity
@Table(name = "tb_pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    private String cpf;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Endereco endereco;
    private Boolean ativo;
}

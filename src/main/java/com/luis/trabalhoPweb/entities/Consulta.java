package com.luis.trabalhoPweb.entities;

import com.luis.trabalhoPweb.dtos.ConsultaDTO;
import com.luis.trabalhoPweb.dtos.EnumMotivoDeCancelamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder

@Entity
@Table(name = "tb_consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    private LocalDateTime agendamento;
    private boolean ativo;
    @Enumerated(EnumType.STRING)
    private EnumMotivoDeCancelamento motivoDeCancelamento;
//    public Consulta(ConsultaDTO dto) {
//        this.id = dto.getId();
//        this.paciente = dto.getPaciente();
//        this.medico = dto.getMedico();
//        this.agendamento = dto.getAgendamento();
//        this.ativo = dto.isAtivo();
//    }
}

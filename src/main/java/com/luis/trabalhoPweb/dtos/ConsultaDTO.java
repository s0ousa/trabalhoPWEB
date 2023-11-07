package com.luis.trabalhoPweb.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luis.trabalhoPweb.entities.Consulta;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaDTO {
    private Long id;
    @NotNull
    private Long pacienteID;
    @NotNull
    private Long medicoID;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime agendamento;
    private boolean ativo;
    private EnumMotivoDeCancelamento motivoDeCancelamento;

    public ConsultaDTO(Consulta entidade) {
        this.id = entidade.getId();
        this.pacienteID = entidade.getPaciente().getId();
        this.medicoID = entidade.getMedico().getId();
        this.agendamento = entidade.getAgendamento();
        this.ativo = entidade.isAtivo();
        this.motivoDeCancelamento = entidade.getMotivoDeCancelamento();
    }

}

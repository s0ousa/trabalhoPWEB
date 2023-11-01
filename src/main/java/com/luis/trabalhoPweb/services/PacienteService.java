package com.luis.trabalhoPweb.services;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.PacienteDTO;
import com.luis.trabalhoPweb.entities.Medico;
import com.luis.trabalhoPweb.entities.Paciente;
import com.luis.trabalhoPweb.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    public PacienteDTO searchById(Long id) {
        Paciente result = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico nao encontrado"));

        return PacienteDTO.builder()
                .nome(result.getNome())
                .email(result.getEmail())
                .cpf(result.getCpf())
                .build();
    }

    public PacienteDTO create(PacienteDTO pacienteDTO) {
        Paciente novoPaciente = new Paciente(pacienteDTO);
        pacienteRepository.save(novoPaciente);

        return pacienteDTO;
    }


}

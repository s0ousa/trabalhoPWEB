package com.luis.trabalhoPweb.services;

import com.luis.trabalhoPweb.dtos.Cancelamento;
import com.luis.trabalhoPweb.dtos.ConsultaDTO;
import com.luis.trabalhoPweb.entities.Consulta;
import com.luis.trabalhoPweb.entities.Medico;
import com.luis.trabalhoPweb.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;

    @Transactional(readOnly = true)
    public ConsultaDTO searchById(Long id) {
        Consulta result = consultaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Consulta nao encontrado"));
        return new ConsultaDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ConsultaDTO> findAll(Map<String, String> param, Pageable pageable) {
        String page = Optional.ofNullable(param.get("page")).orElse("0");
        int pageSize = Integer.parseInt(Optional.ofNullable(param.get("size")).orElse("10"));
        String metodoOrdenacao = Optional.ofNullable(param.get("sortBy")).orElse("agendamento");

        pageable = PageRequest.of(Integer.parseInt(page),pageSize, Sort.by(metodoOrdenacao));
        Page<Consulta> result = consultaRepository.findAll(pageable);
        return result.map(ConsultaDTO::new);
    }

    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        boolean existeConsultaNessaData = consultaRepository.ConsultaAgendadaNoDia(consultaDTO.getId(), consultaDTO.getAgendamento()).isPresent();

        if(existeConsultaNessaData){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Existe consulta Nessa Data para este paciente");
        }

        RegrasDeConsulta regrasDeConsulta = new RegrasDeConsulta();
        regrasDeConsulta.validaConsulta(consultaDTO.getAgendamento());


        List <Long> medicosIndisponiveisIds = consultaRepository.medicosIndisponiveis
                        (consultaDTO.getAgendamento().minusHours(1)
                        ,consultaDTO.getAgendamento().plusHours(1));

        Consulta novaConsulta = new Consulta();

        if(consultaDTO.getMedicoID()==null){
           List<Medico> medicosDisponiveis = medicoService.buscaMedicosDisponiveis(medicosIndisponiveisIds);

            Random aleatorio = new Random();
            novaConsulta.setMedico((medicosDisponiveis.get(
                    aleatorio.nextInt(0,medicosDisponiveis.size()))));
        } else {
            if(medicosIndisponiveisIds.contains(consultaDTO.getMedicoID())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse médico está indisponivel");
            } else novaConsulta.setMedico(medicoService.buscaMedico(consultaDTO.getMedicoID()));
        }

        novaConsulta.setAgendamento((consultaDTO.getAgendamento()));

        novaConsulta.setPaciente(pacienteService.buscaPaciente(consultaDTO.getPacienteID()));
        novaConsulta.setAtivo(true);

        return new ConsultaDTO(consultaRepository.save(novaConsulta));
    }

    public ConsultaDTO desmarcaConsulta(Long id, Cancelamento cancelamento) {
        Consulta result = consultaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Consulta nao encontrado"));

        result.setMotivoDeCancelamento(cancelamento.getMotivoDeCancelamento());
        result.setAtivo(false);

        return new ConsultaDTO(consultaRepository.save(result));
    }

}

package com.luis.trabalhoPweb.services;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.MedicoMinDTO;
import com.luis.trabalhoPweb.entities.Medico;
import com.luis.trabalhoPweb.repositories.EnderecoRepository;
import com.luis.trabalhoPweb.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;



    @Transactional(readOnly = true)
    public MedicoMinDTO findById(Long id) {
        Medico result = medicoRepository.findById(id).get();
        return new MedicoMinDTO(result);
    }

    @Transactional(readOnly = true)
    public List<MedicoMinDTO> findAll() {
        List<Medico> result = medicoRepository.findAll();
        List <MedicoMinDTO> dto = result.stream().map(MedicoMinDTO::new).toList();
        return dto;
    }

    public ResponseEntity<MedicoDTO> create(MedicoDTO medicoDTO) {
        Medico medicoCriado = new Medico(medicoDTO);
        enderecoRepository.save(medicoDTO.getEndereco());
        medicoRepository.save(medicoCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoDTO);
    }
}

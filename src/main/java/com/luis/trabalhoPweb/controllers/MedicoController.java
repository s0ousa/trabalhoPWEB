package com.luis.trabalhoPweb.controllers;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.MedicoMinDTO;
import com.luis.trabalhoPweb.entities.Medico;
import com.luis.trabalhoPweb.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoMinDTO> findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @GetMapping
    public List<MedicoMinDTO> findAll() {
        return medicoService.findAll();
    }


    //tem q retornar o status d requisção + objeto criado
    @PostMapping
    public ResponseEntity<MedicoDTO> create(@RequestBody MedicoDTO medicoDTO) {
        return medicoService.create(medicoDTO);
    }
}

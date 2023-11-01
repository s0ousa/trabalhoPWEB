package com.luis.trabalhoPweb.controllers;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.PacienteDTO;
import com.luis.trabalhoPweb.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(pacienteService.searchById(id));
//    }
}

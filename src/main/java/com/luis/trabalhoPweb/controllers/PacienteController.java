package com.luis.trabalhoPweb.controllers;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.PacienteDTO;
import com.luis.trabalhoPweb.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@Valid @RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.create(pacienteDTO));
    }
}

package com.luis.trabalhoPweb.controllers;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.MedicoMinDTO;
import com.luis.trabalhoPweb.dtos.PacienteDTO;
import com.luis.trabalhoPweb.dtos.PacienteMinDTO;
import com.luis.trabalhoPweb.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.searchById(id));
    }
    @GetMapping
    public ResponseEntity<Page<PacienteMinDTO>>  findAll(@RequestParam Map<String, String> param, Pageable pageable) {
        return ResponseEntity.ok(pacienteService.findAll(param, pageable));
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@Valid @RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.create(pacienteDTO));
    }


    @DeleteMapping(value = "/{id}")
    public PacienteDTO inativa(@PathVariable Long id) {
        return pacienteService.inativa(id);
    }
}

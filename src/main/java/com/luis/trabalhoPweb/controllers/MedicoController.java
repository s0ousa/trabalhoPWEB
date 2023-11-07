package com.luis.trabalhoPweb.controllers;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.MedicoMinDTO;
import com.luis.trabalhoPweb.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.searchById(id));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoMinDTO>>  findAll(@RequestParam Map<String, String> param, Pageable pageable) {
        return ResponseEntity.ok(medicoService.findAll(param, pageable));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> create(@RequestBody MedicoDTO medicoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.create(medicoDTO));
    }

    @PutMapping(value = "/{id}")
    public MedicoDTO update(@PathVariable Long id, @RequestBody MedicoDTO dto) {
        return medicoService.updateById(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public MedicoDTO inativa(@PathVariable Long id) {
        return medicoService.inativa(id);
    }

}

package com.luis.trabalhoPweb.repositories;

import com.luis.trabalhoPweb.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findByIdAndAtivo(Long id, boolean ativo);



}

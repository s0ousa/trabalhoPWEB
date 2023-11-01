package com.luis.trabalhoPweb.repositories;

import com.luis.trabalhoPweb.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}

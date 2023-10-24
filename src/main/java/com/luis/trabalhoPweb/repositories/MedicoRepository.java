package com.luis.trabalhoPweb.repositories;

import com.luis.trabalhoPweb.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}

package com.luis.trabalhoPweb.repositories;

import com.luis.trabalhoPweb.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findByIdAndAtivo(Long id, boolean ativo);
    Optional<List<Medico>> findAllByAtivo(boolean ativo);
}

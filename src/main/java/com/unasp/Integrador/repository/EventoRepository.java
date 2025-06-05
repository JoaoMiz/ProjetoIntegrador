package com.unasp.Integrador.repository;

import com.unasp.Integrador.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}

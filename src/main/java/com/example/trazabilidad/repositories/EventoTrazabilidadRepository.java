package com.example.trazabilidad.repositories;

import com.example.trazabilidad.entities.EventoTrazabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoTrazabilidadRepository extends JpaRepository<EventoTrazabilidad, Long> {

}
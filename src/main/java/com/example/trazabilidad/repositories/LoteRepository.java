package com.example.trazabilidad.repositories;

import com.example.trazabilidad.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

}
package com.example.trazabilidad.services;

import com.example.trazabilidad.dtos.EventoCreateDto;
import com.example.trazabilidad.dtos.EventoDto;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    public Optional<EventoDto> crearEvento(Long id , EventoCreateDto dto);
    public Optional<List<EventoDto>> findAllEventos(Long id);
    public Optional<List<String>> findRutas(Long id);
}

package com.example.trazabilidad.services;

import com.example.trazabilidad.dtos.LoteCreateDto;
import com.example.trazabilidad.dtos.LoteDto;
import com.example.trazabilidad.dtos.LoteUpdateDto;
import com.example.trazabilidad.mappers.LoteMapper;

import java.util.List;
import java.util.Optional;

public interface LoteService {

    LoteDto save(LoteCreateDto dto, Long productoId, LoteMapper loteMapper);
    LoteDto update(LoteUpdateDto dto);
    Optional<LoteDto> findById(Long id);
    List<LoteDto> findAllByProductoId(Long productoId);
    boolean delete(Long id);
    Optional<Object> updateEstado(Long id);
}
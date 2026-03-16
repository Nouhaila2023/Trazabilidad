package com.example.trazabilidad.dtos;

import java.util.List;

public record ProductoDto(Long id, String codigo , String nombre , List<LoteResumenDto> lotes) {
}
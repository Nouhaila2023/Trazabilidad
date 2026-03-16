package com.example.trazabilidad.dtos;

import java.util.List;

public record ProductoCreateDto(String codigo , String nombre , String descripcion, List<LoteResumenDto> lotes) {
}
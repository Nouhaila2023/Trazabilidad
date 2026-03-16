package com.example.trazabilidad.dtos;

import java.time.LocalDate;

public record LoteDto(Long id, String numeroLote, LocalDate fechaProduccion, Integer cantidad, String estado , ProductoBasicoDto producto) {
}
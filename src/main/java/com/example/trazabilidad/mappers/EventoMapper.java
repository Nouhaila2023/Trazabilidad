package com.example.trazabilidad.mappers;
import com.example.trazabilidad.entities.EventoTrazabilidad;
import com.example.trazabilidad.dtos.EventoCreateDto;
import com.example.trazabilidad.dtos.EventoDto;


public interface EventoMapper {
    EventoDto toDto(EventoTrazabilidad evento);
    EventoTrazabilidad eventoCreateDtoToEntity(EventoCreateDto dto);
}

package com.example.trazabilidad.mappers;

import com.example.trazabilidad.dtos.LoteCreateDto;
import com.example.trazabilidad.dtos.LoteDto;
import com.example.trazabilidad.entities.Lote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoteMapper {
    LoteDto toDto(Lote lote);
    Lote loteCreateDtoToEntity(LoteCreateDto dto);
}
package com.example.trazabilidad.mappers;

import com.example.trazabilidad.dtos.ProductoCreateDto;
import com.example.trazabilidad.dtos.ProductoDto;
import com.example.trazabilidad.dtos.ProductoUpdateDto;
import com.example.trazabilidad.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDto toDto(Producto producto);
    Producto productoCreateDtoToEntity(ProductoCreateDto dto);

}
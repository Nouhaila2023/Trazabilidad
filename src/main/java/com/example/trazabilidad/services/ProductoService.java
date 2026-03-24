package com.example.trazabilidad.services;

import com.example.trazabilidad.dtos.*;
import com.example.trazabilidad.entities.Lote;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public ProductoDto create(ProductoCreateDto dto);
    public List<ProductoDto> findAll();
    public Optional<ProductoDto> findById(Long id);
    Optional<ProductoDto> updateProducto(Long id, ProductoUpdateDto producto );

    public boolean delete(Long id);

    //relacionadas con el Lote
    public Optional<LoteDto> crearLote(Long productoId, LoteCreateDto dto);

    Optional<List<Lote>> listarLotes(Long productoId);
}
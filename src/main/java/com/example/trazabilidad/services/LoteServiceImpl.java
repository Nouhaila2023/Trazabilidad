package com.example.trazabilidad.services;


import com.example.trazabilidad.dtos.LoteCreateDto;
import com.example.trazabilidad.dtos.LoteDto;
import com.example.trazabilidad.dtos.LoteUpdateDto;
import com.example.trazabilidad.entities.Lote;
import com.example.trazabilidad.entities.Producto;
import com.example.trazabilidad.mappers.LoteMapper;
import com.example.trazabilidad.repositories.LoteRepository;
import com.example.trazabilidad.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImpl implements LoteService {

    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private LoteMapper mapper;
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public LoteDto save(LoteCreateDto dto, Long productoId, LoteMapper loteMapper) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto con id " + productoId + " no encontrado"));

        Lote lote = loteMapper.loteCreateDtoToEntity(dto);
        lote.setProducto(producto);
        return loteMapper.toDto(loteRepository.save(lote));
    }

    @Override
    public LoteDto update(LoteUpdateDto dto) {
        return null;
    }

    @Override
    public Optional<LoteDto> findById(Long id) {
        return loteRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<LoteDto> findAllByProductoId(Long productoId) {
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Lote> lote = loteRepository.findById(id);
        if (lote.isPresent()) {
            loteRepository.delete(lote.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<Object> updateEstado(Long id) {
        return Optional.empty();
    }


}
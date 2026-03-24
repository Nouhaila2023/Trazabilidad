package com.example.trazabilidad.services;

import com.example.trazabilidad.dtos.*;
import com.example.trazabilidad.entities.Lote;
import com.example.trazabilidad.entities.Producto;
import com.example.trazabilidad.mappers.ProductoMapper;
import com.example.trazabilidad.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoMapper mapper;
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoDto create(ProductoCreateDto dto) {

        Producto producto = mapper.productoCreateDtoToEntity(dto);
        return mapper.toDto(productoRepository.save(producto));
    }

    @Override
    public List<ProductoDto> findAll() {
        return productoRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<ProductoDto> findById(Long id) {
        return productoRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<ProductoDto> updateProducto(Long id, ProductoUpdateDto producto) {
        Producto p = productoRepository.findById(id).orElse(null);

        p.setNombre(producto.nombre());
        p.setDescripcion(producto.descripcion());
        p.setCodigo(producto.codigo());


        return Optional.ofNullable(mapper.toDto(productoRepository.save(p)));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);

        if (producto.isPresent()) {
            productoRepository.delete(producto.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<LoteDto> crearLote(Long productoId, LoteCreateDto dto) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Lote>> listarLotes(Long productoId) {
        return productoRepository.findById(productoId)
                .map(producto ->
                        producto.getLotes()
                                .stream()
                                .toList()
                );
    }
}
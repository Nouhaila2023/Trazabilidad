package com.example.trazabilidad.services;

import com.example.trazabilidad.dtos.EventoCreateDto;
import com.example.trazabilidad.dtos.EventoDto;
import com.example.trazabilidad.entities.EventoTrazabilidad;
import com.example.trazabilidad.entities.Lote;
import com.example.trazabilidad.mappers.EventoMapper;
import com.example.trazabilidad.repositories.EventoTrazabilidadRepository;
import com.example.trazabilidad.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private EventoTrazabilidadRepository eventoRepository;

    @Autowired
    private EventoMapper mapper;

    @Override
    public Optional<EventoDto> crearEvento(Long id, EventoCreateDto dto) {
        Optional<Lote> loteOptional = loteRepository.findById(id);
        if (loteOptional.isPresent()){
            Lote lote = loteOptional.get();
            EventoTrazabilidad evento = mapper.eventoCreateDtoToEntity(dto);
            evento.setTimestamp(LocalDateTime.now());
            evento.setLote(lote);
            return Optional.of(mapper.toDto(eventoRepository.save(evento)));
        }else {
            return  Optional.empty();
        }
    }

    @Override
    public Optional<List<EventoDto>> findAllEventos(Long id) {
        Optional<Lote> loteOptional = loteRepository.findById(id);

        if (loteOptional.isPresent()){
            List<EventoDto> eventos = eventoRepository
                    .findByLoteIdOrderByTimestampAsc(id)
                    .stream()
                    .map(mapper::toDto)
                    .toList();

            return Optional.of(eventos);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<String>> findRutas(Long id) {
        Optional<Lote> loteOptional = loteRepository.findById(id);

        if (loteOptional.isPresent()) {

            List<String> ruta = eventoRepository
                    .findByLoteIdOrderByTimestampAsc(id)
                    .stream()
                    .map(EventoTrazabilidad::getUbicacion)
                    .toList();

            return Optional.of(ruta);

        } else {
            return Optional.empty();
        }
    }
}
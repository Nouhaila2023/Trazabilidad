package com.example.trazabilidad.controller;

import com.example.trazabilidad.dtos.LoteDto;
import com.example.trazabilidad.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    @Autowired
    private LoteService service;

    @GetMapping("/{id}")
    public ResponseEntity<LoteDto> getLote(@PathVariable Long id){
        Optional<LoteDto> late = service.findById(id);
        return late.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Object> updateEstado(@PathVariable Long id ){
        return service.updateEstado(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

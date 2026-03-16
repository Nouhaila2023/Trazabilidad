package com.example.trazabilidad.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lotes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String numeroLote;
    private LocalDate fechaProduccion;
    private Integer cantidad;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @OneToMany(mappedBy = "lote" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventoTrazabilidad> eventoTrazabilidads = new ArrayList<>();
    public void addEvento(EventoTrazabilidad e){
        eventoTrazabilidads.add(e);
        e.setLote(this);
    }
}
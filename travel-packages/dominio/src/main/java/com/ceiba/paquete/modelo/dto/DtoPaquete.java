package com.ceiba.paquete.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPaquete {
    private Long id;
    private Double precio;
    private String estado;
    private String ciudad;
    private String hotel;
    private String descripcion;
    private Long cupos;
    private Long dias;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaHasta;
}

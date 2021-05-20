package com.ceiba.paquete.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPaquete {
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

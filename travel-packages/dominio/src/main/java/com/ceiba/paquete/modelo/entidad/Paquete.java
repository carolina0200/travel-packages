package com.ceiba.paquete.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Paquete {
    private Long id;
    private Long precio;
    private String estado;
    private String ciudad;
    private String hotel;
    private String descripcion;
    private Long cupos;
    private Long dias;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaHasta;

    public Paquete(Long id, Long precio, String estado, String ciudad, String hotel, String descripcion, Long cupos, Long dias, LocalDateTime fechaCreacion, LocalDateTime fechaHasta) {
        this.id = id;
        this.precio = precio;
        this.estado = estado;
        this.ciudad = ciudad;
        this.hotel = hotel;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.dias = dias;
        this.fechaCreacion = fechaCreacion;
        this.fechaHasta = fechaHasta;
    }
}

package com.ceiba.paquete.servicio.testdatabuilder;

import com.ceiba.paquete.modelo.entidad.Paquete;

import java.time.LocalDateTime;

public class PaqueteTestDataBuilder {
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

    public PaqueteTestDataBuilder() {
        this.precio = 1000000L;
        this.estado = "A";
        this.ciudad = "Cartagena";
        this.hotel = "Decameron";
        this.descripcion = "PAQUETE TODO INCLUIDO 4 DIAS 3 NOCHES";
        this.cupos = 50L;
        this.dias = 4L;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaHasta = this.fechaCreacion.plusDays(30);
    }

    public Paquete build() {
        return new Paquete(id, precio, estado, ciudad, hotel, descripcion, cupos, dias, fechaCreacion, fechaHasta);
    }
}

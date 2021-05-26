package com.ceiba.paquete.servicio.testdatabuilder;

import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.paquete.modelo.dto.DtoPaquete;
import com.ceiba.paquete.modelo.entidad.Paquete;

import java.time.LocalDateTime;
import java.time.Month;

public class PaqueteTestDataBuilder {
    private Long id;
    private Double precio;
    private String estado;
    private String ciudad;
    private String hotel;
    private String descripcion;
    private Long cupos;
    private Long dias;
    private LocalDateTime fechaCreacion;

    public PaqueteTestDataBuilder() {
        this.precio = 1000000D;
        this.estado = "A";
        this.ciudad = "Cartagena";
        this.hotel = "Decameron";
        this.descripcion = "PAQUETE TODO INCLUIDO 4 DIAS 3 NOCHES";
        this.cupos = 50L;
        this.dias = 4L;
        this.fechaCreacion = LocalDateTime.now();
    }

    public PaqueteTestDataBuilder conCupos(Long cupos) {
        this.cupos = cupos;
        return this;
    }

    public PaqueteTestDataBuilder conEstadoInactivo() {
        this.estado = "I";
        return this;
    }

    public Paquete build() {
        return new Paquete(id, precio, estado, ciudad, hotel, descripcion, cupos, dias, fechaCreacion);
    }

    public DtoPaquete buildDto() {
        return new DtoPaquete(id, precio, estado, ciudad, hotel, descripcion, cupos, dias, fechaCreacion);
    }
}

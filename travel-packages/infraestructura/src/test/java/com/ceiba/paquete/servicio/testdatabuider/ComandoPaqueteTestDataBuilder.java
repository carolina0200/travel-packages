package com.ceiba.paquete.servicio.testdatabuider;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.paquete.comando.ComandoPaquete;

import java.time.LocalDateTime;

public class ComandoPaqueteTestDataBuilder {
    private Long id;
    private Double precio;
    private String estado;
    private String ciudad;
    private String hotel;
    private String descripcion;
    private Long cupos;
    private Long dias;
    private LocalDateTime fechaCreacion;

    public ComandoPaqueteTestDataBuilder() {
        this.precio = 1000000D;
        this.estado = "A";
        this.ciudad = "Cartagena";
        this.hotel = "Decameron";
        this.descripcion = "PAQUETE TODO INCLUIDO 4 DIAS 3 NOCHES";
        this.cupos = 50L;
        this.dias = 4L;
        this.fechaCreacion = LocalDateTime.now();
    }

    public ComandoPaquete build() {
        return new ComandoPaquete(id, precio, estado, ciudad, hotel, descripcion, cupos, dias, fechaCreacion);
    }
}

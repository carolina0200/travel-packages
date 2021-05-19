package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public class CompraTestDataBuilder {
    private Long id;
    private Long idPaquete;
    private Long valor;
    private String vigencia;
    private String identificacion;
    private String nombre;
    private String correo;
    private Long numeroMenores;
    private Long numeroAdultos;

    private LocalDateTime fechaCompra;
    private LocalDateTime fechaIda;
    private LocalDateTime fechaRegreso;

    public CompraTestDataBuilder() {
        this.valor = 1000000L;
        this.vigencia = "A";
        this.identificacion = "1007238543";
        this.nombre = "Carolina Giraldo";
        this.correo = "test@gmail.com";
        this.numeroMenores = 3L;
        this.numeroAdultos = 2L;
        this.fechaCompra = LocalDateTime.now();
        this.fechaIda = LocalDateTime.now().plusDays(6);
        this.fechaRegreso = this.fechaIda.plusDays(3);
    }

    public Compra build() {
        return new Compra(id, idPaquete, valor, vigencia, identificacion, nombre,
                correo, numeroMenores, numeroAdultos, fechaCompra, fechaIda, fechaRegreso);
    }
}

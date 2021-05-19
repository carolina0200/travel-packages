package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDateTime;

public class ComandoCompraTestDataBuilder {
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

    public ComandoCompraTestDataBuilder() {
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

    public ComandoCompra build() {
        return new ComandoCompra(id, idPaquete, valor, vigencia, identificacion, nombre,
        correo, numeroMenores, numeroAdultos, fechaCompra, fechaIda, fechaRegreso);
    }
}

package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDateTime;
import java.time.Month;

public class ComandoCompraTestDataBuilder {
    private Long id;
    private Long idPaquete;
    private Double valor;
    private String nombre;
    private String correo;
    private Long numeroMenores;
    private Long numeroAdultos;

    private LocalDateTime fechaCompra;
    private LocalDateTime fechaIda;
    private LocalDateTime fechaRegreso;

    public ComandoCompraTestDataBuilder() {
        this.idPaquete = 1L;
        this.valor = 1000000D;
        this.nombre = "Carolina Giraldo";
        this.correo = "test@gmail.com";
        this.numeroMenores = 3L;
        this.numeroAdultos = 1L;
        this.fechaCompra = LocalDateTime.now();
        this.fechaIda = LocalDateTime.now().plusDays(6);
        this.fechaRegreso = this.fechaIda.plusDays(2);
    }

    public ComandoCompraTestDataBuilder conFechaIdaSemana() {
        this.fechaCompra = LocalDateTime.of(2021, Month.MAY, 19, 15, 00);
        this.fechaIda = LocalDateTime.of(2021, Month.MAY, 20, 15, 00);
        this.fechaRegreso = LocalDateTime.of(2021, Month.MAY, 23, 15, 00);
        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, idPaquete, valor, nombre,
        correo, numeroMenores, numeroAdultos, fechaCompra, fechaIda, fechaRegreso);
    }


}

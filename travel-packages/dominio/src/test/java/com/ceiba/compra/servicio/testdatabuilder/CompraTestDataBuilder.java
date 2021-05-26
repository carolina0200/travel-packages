package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;
import java.time.Month;

public class CompraTestDataBuilder {
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

    public CompraTestDataBuilder() {
        this.idPaquete = 1L;
        this.valor = 1000000D;
        this.nombre = "Carolina Giraldo";
        this.correo = "test@gmail.com";
        this.numeroMenores = 3L;
        this.numeroAdultos = 2L;
        this.fechaCompra = LocalDateTime.now();
        this.fechaIda = LocalDateTime.now().plusDays(6);
        this.fechaRegreso = this.fechaIda.plusDays(3);
    }

    public CompraTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public CompraTestDataBuilder conNumeroMenores(Long numero) {
        this.numeroMenores = numero;
        return this;
    }

    public CompraTestDataBuilder conNumeroAdultos(Long numero) {
        this.numeroAdultos = numero;
        return this;
    }

    public CompraTestDataBuilder conFechaIdaSabado() {
        this.fechaCompra = LocalDateTime.of(2021, Month.MAY, 20, 15, 00);
        this.fechaIda = LocalDateTime.of(2021, Month.MAY, 22, 15, 00);
        this.fechaRegreso = LocalDateTime.of(2021, Month.MAY, 24, 15, 00);
        return this;
    }

    public CompraTestDataBuilder conFechaIdaSemana() {
        this.fechaCompra = LocalDateTime.of(2021, Month.MAY, 19, 15, 00);
        this.fechaIda = LocalDateTime.of(2021, Month.MAY, 20, 15, 00);
        this.fechaRegreso = LocalDateTime.of(2021, Month.MAY, 22, 15, 00);
        return this;
    }

    public Compra build() {
        return new Compra(id, idPaquete, valor, nombre,
                correo, numeroMenores, numeroAdultos, fechaCompra, fechaIda, fechaRegreso);
    }
}

package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Compra {
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

    public Compra(Long id, Long idPaquete, Long valor, String vigencia, String identificacion, String nombre, String correo, Long numeroMenores, Long numeroAdultos, LocalDateTime fechaCompra, LocalDateTime fechaIda, LocalDateTime fechaRegreso) {
        this.id = id;
        this.idPaquete = idPaquete;
        this.valor = valor;
        this.vigencia = vigencia;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.numeroMenores = numeroMenores;
        this.numeroAdultos = numeroAdultos;
        this.fechaCompra = fechaCompra;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
    }
}

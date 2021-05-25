package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompra {
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
}

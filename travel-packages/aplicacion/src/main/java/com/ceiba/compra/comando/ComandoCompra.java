package com.ceiba.compra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCompra {
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

}

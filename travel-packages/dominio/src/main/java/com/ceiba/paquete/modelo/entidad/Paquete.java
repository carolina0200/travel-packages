package com.ceiba.paquete.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;
import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Paquete {
    private static final String MENSAJE_PRECIO_OBLIGATORIO = "El precio del paquete es obligatorio.";
    private static final String MENSAJE_ESTADO_OBLIGATORIO = "El estado del paquete es obligatorio.";
    private static final String MENSAJE_CUIDAD_OBLIGATORIO = "La ciudad de destino del paquete es obligatoria.";
    private static final String MENSAJE_CUPOS_OBLIGATORIO = "los cupos del paquete son obligatorios.";
    private static final String MENSAJE_DIAS_OBLIGATORIO = "Los dias que incluye el paquete son obligatorios.";
    private static final String MENSAJE_FECHA_CREACION_OBLIGATORIO = "La fecha de creación es obligatoria.";
    private static final String MENSAJE_FECHA_HASTA_OBLIGATORIO = "La fecha hasta del paquete es obligatoria.";

    private static final String MENSAJE_FECHA_HASTA_VALIDACION = "La fecha hasta debe ser mayor a la fecha actual";
    private static final String MENSAJE_PRECIO_POSITIVO = "El precio del paquete debe ser 0 (cero) o más";

    private Long id;
    private Double precio;
    private String estado;
    private String ciudad;
    private String hotel;
    private String descripcion;
    private Long cupos;
    private Long dias;
    private LocalDateTime fechaCreacion;

    public Paquete(Long id, Double precio, String estado, String ciudad, String hotel, String descripcion, Long cupos, Long dias, LocalDateTime fechaCreacion) {
        validarObligatorio(precio, MENSAJE_PRECIO_OBLIGATORIO);
        validarPositivo(precio, MENSAJE_PRECIO_POSITIVO);
        validarObligatorio(estado, MENSAJE_ESTADO_OBLIGATORIO);
        validarObligatorio(ciudad, MENSAJE_CUIDAD_OBLIGATORIO);
        validarObligatorio(cupos, MENSAJE_CUPOS_OBLIGATORIO);
        validarObligatorio(dias, MENSAJE_DIAS_OBLIGATORIO);
        validarObligatorio(fechaCreacion, MENSAJE_FECHA_CREACION_OBLIGATORIO);

        this.id = id;
        this.precio = precio;
        this.estado = estado;
        this.ciudad = ciudad;
        this.hotel = hotel;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.dias = dias;
        this.fechaCreacion = fechaCreacion;
    }

}

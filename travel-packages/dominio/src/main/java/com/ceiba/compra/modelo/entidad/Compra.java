package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Compra {
    private static final String MENSAJE_ID_PAQUETE_OBLIGATORIO = "El id del paquete es obligatorio.";
    private static final String MENSAJE_VALOR_OBLIGATORIO = "El valor del paquete es obligatorio.";
    private static final String MENSAJE_VIGENCIA_OBLIGATORIO = "La vigencia es obligatoria.";
    private static final String MENSAJE_NOMBRE_OBLIGATORIO = "El nombre del comprador es obligatorio.";
    private static final String MENSAJE_CORREO_OBLIGATORIO = "El correo del comprador es obligatorio.";
    private static final String MENSAJE_NUMERO_ADULTOS_OBLIGATORIO = "El numero de adultos es obligatorio.";
    private static final String MENSAJE_FECHA_COMPRA_OBLIGATORIO = "La fecha de creación es obligatoria.";
    private static final String MENSAJE_FECHA_IDA_OBLIGATORIO = "La fecha de ida es obligatoria.";
    private static final String MENSAJE_FECHA_REGRESO_OBLIGATORIO = "La fecha de regreso es obligatoria.";

    private static final String MENSAJE_VALOR_POSITIVO = "El valor de la compra debe ser 0 (cero) o más";

    private static final String MENSAJE_VIGENCIA_ACTIVA_INACTIVA = "En vigencia va A para Activa e I para Inactiva";
    private static final String REGEX_VIGENCIA = "A|I";

    private static final String MENSAJE_CORREO_CORRECTO = "El correo debe seguir el siguiente formato (correo@servicio.com)";
    private static final String REGEX_CORREO = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";

    private static final String MENSAJE_NUMERO_ADULTOS_POSITIVO = "El numero de personas adultas debe ser 1 (cero) o más";
    private static final String MENSAJE_NUMERO_ADULTOS_MAYOR_CERO = "El numero de personas adultas debe ser 1 (cero)";
    private static final Long MINIMO_ADULTOS = 1L;

    private static final String MENSAJE_FECHA_COMPRA_VALIDACION = "La fecha de compra debe ser antes de la fecha de ida.";
    private static final String MENSAJE_FECHAS_VALIDACION = "La fecha de ida debe ser antes de la fecha de regreso.";

    public static final int NUMERO_MINIMO_PERSONAS_DESCUENTO = 5;
    public static final int NUMERO_MINIMO_MENORES_DESCUENTO_SEMANA = 1;

    private Long id;
    private Long idPaquete;
    private Double valor;
    private String vigencia;
    private String nombre;
    private String correo;
    private Long numeroMenores;
    private Long numeroAdultos;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaIda;
    private LocalDateTime fechaRegreso;

    public Compra(Long id, Long idPaquete, Double valor, String vigencia, String nombre, String correo, Long numeroMenores, Long numeroAdultos, LocalDateTime fechaCompra, LocalDateTime fechaIda, LocalDateTime fechaRegreso) {
        validarObligatorio(idPaquete, MENSAJE_ID_PAQUETE_OBLIGATORIO);
        validarObligatorio(valor, MENSAJE_VALOR_OBLIGATORIO);
        validarPositivo(valor, MENSAJE_VALOR_POSITIVO);
        validarObligatorio(vigencia, MENSAJE_VIGENCIA_OBLIGATORIO);
        validarRegex(vigencia, REGEX_VIGENCIA, MENSAJE_VIGENCIA_ACTIVA_INACTIVA);
        validarObligatorio(nombre, MENSAJE_NOMBRE_OBLIGATORIO);
        validarObligatorio(correo, MENSAJE_CORREO_OBLIGATORIO);
        validarRegex(correo, REGEX_CORREO, MENSAJE_CORREO_CORRECTO);
        validarObligatorio(numeroAdultos, MENSAJE_NUMERO_ADULTOS_OBLIGATORIO);
        validarPositivo(numeroAdultos.doubleValue(), MENSAJE_NUMERO_ADULTOS_POSITIVO);
        validarMenor(MINIMO_ADULTOS, numeroAdultos, MENSAJE_NUMERO_ADULTOS_MAYOR_CERO);
        validarObligatorio(fechaCompra, MENSAJE_FECHA_COMPRA_OBLIGATORIO);
        validarMenor(fechaCompra, fechaIda, MENSAJE_FECHA_COMPRA_VALIDACION);
        validarObligatorio(fechaIda, MENSAJE_FECHA_IDA_OBLIGATORIO);
        validarObligatorio(fechaRegreso, MENSAJE_FECHA_REGRESO_OBLIGATORIO);
        validarMenor(fechaIda, fechaRegreso, MENSAJE_FECHAS_VALIDACION);

        this.id = id;
        this.idPaquete = idPaquete;
        this.valor = valor;
        this.vigencia = vigencia;
        this.nombre = nombre;
        this.correo = correo;
        this.numeroMenores = numeroMenores;
        this.numeroAdultos = numeroAdultos;
        this.fechaCompra = fechaCompra;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;

    }

    public boolean fechaIdaEsFinDeSemanda() {
        return this.fechaIda.getDayOfWeek() == DayOfWeek.SATURDAY || this.fechaIda.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public boolean hayMenores() {
        return this.getNumeroMenores() >= NUMERO_MINIMO_MENORES_DESCUENTO_SEMANA;
    }

    public boolean aplicaDescuentoNumeroPersonas() {
        return (this.numeroAdultos + this.numeroMenores) >= NUMERO_MINIMO_PERSONAS_DESCUENTO;
    }

}

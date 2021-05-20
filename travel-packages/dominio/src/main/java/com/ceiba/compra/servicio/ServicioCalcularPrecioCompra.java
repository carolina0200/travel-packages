package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.modelo.dto.DtoPaquete;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

import java.time.DayOfWeek;

public class ServicioCalcularPrecioCompra {

    private static final String MENSAJE_PAQUETE_NO_EXISTE = "El paquete no existe en el sistema";

    private static final double PORC_RECARGOS_FIN_DE_SEMANA = 0.1;
    private static final double PORC_DESCUENTO_MENORES = 0.5;
    private static final double PORC_DESCUENTO_CINCO_PERSONAS_O_MAS = 0.2;

    private final RepositorioPaquete repositorioPaquete;
    private final DaoPaquete daoPaquete;

    public ServicioCalcularPrecioCompra(RepositorioPaquete repositorioPaquete, DaoPaquete daoPaquete){
        this.repositorioPaquete = repositorioPaquete;
        this.daoPaquete = daoPaquete;
    }

    public Double ejecutar(Compra compra) {
        validarExistenciaPaquete(compra.getIdPaquete());
        DtoPaquete paquete = obtenerPaquete(compra.getIdPaquete());
        return calcularValor(compra, paquete);
    }

    private void validarExistenciaPaquete(Long idPaquete) {
        boolean existe = this.repositorioPaquete.existe(idPaquete);
        if(!existe) {
            throw new ExcepcionSinDatos(MENSAJE_PAQUETE_NO_EXISTE);
        }
    }

    private DtoPaquete obtenerPaquete(Long idPaquete) {
        return daoPaquete.obtener(idPaquete);
    }

    private Double calcularValor(Compra compra, DtoPaquete paquete) {
        Long numeroPersonas = compra.getNumeroMenores() + compra.getNumeroAdultos();
        Double valor = paquete.getPrecio() * numeroPersonas;

        if(compra.getFechaIda().getDayOfWeek() == DayOfWeek.SATURDAY || compra.getFechaIda().getDayOfWeek() == DayOfWeek.SUNDAY) {
            valor += valor * PORC_RECARGOS_FIN_DE_SEMANA;
        } else if (compra.getNumeroMenores() > 1) {
            valor -= (compra.getNumeroMenores() * paquete.getPrecio()) * PORC_DESCUENTO_MENORES;
        }
        if(numeroPersonas >= 5) {
            valor -= valor * PORC_DESCUENTO_CINCO_PERSONAS_O_MAS;
        }
        return valor;
    }
}

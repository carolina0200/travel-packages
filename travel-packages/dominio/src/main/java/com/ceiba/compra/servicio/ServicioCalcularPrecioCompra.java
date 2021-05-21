package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioCalcularPrecioCompra {

    private static final String MENSAJE_PAQUETE_NO_EXISTE = "El paquete no existe en el sistema";

    private static final double PORC_RECARGOS_FIN_DE_SEMANA = 0.1;
    private static final double PORC_DESCUENTO_MENORES = 0.5;
    private static final double PORC_DESCUENTO_CINCO_PERSONAS_O_MAS = 0.2;

    private final RepositorioPaquete repositorioPaquete;

    public ServicioCalcularPrecioCompra(RepositorioPaquete repositorioPaquete){
        this.repositorioPaquete = repositorioPaquete;
    }

    public Double ejecutar(Compra compra) {
        validarExistenciaPaquete(compra.getIdPaquete());
        return calcularValor(compra, repositorioPaquete.obtenerPrecio(compra.getIdPaquete()));
    }

    private void validarExistenciaPaquete(Long idPaquete) {
        boolean existe = this.repositorioPaquete.existe(idPaquete);
        if(!existe) {
            throw new ExcepcionSinDatos(MENSAJE_PAQUETE_NO_EXISTE);
        }
    }

    private Double calcularValor(Compra compra, Double precioPaquete) {
        Double valor = precioPaquete * (compra.getNumeroMenores() + compra.getNumeroAdultos());
        if(compra.fechaIdaEsFinDeSemanda()) {
            valor += valor * PORC_RECARGOS_FIN_DE_SEMANA;
        } else if (compra.hayMenores()) {
            valor -= (compra.getNumeroMenores() * precioPaquete) * PORC_DESCUENTO_MENORES;
        }
        if(compra.aplicaDescuentoNumeroPersonas()) {
            valor -= valor * PORC_DESCUENTO_CINCO_PERSONAS_O_MAS;
        }
        return valor;
    }
}

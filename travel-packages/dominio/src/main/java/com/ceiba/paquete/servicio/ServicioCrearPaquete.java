package com.ceiba.paquete.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioCrearPaquete {

    private static final String MENSAJE_EL_PAQUETE_YA_EXISTE = "El paquete ya existe en el sistema";

    private final RepositorioPaquete repositorioPaquete;

    public ServicioCrearPaquete(RepositorioPaquete repositorioPaquete) {
        this.repositorioPaquete = repositorioPaquete;
    }

    public Long ejecutar(Paquete paquete) {
        validarExistenciaPrevia(paquete.getId());
        return this.repositorioPaquete.crear(paquete);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioPaquete.existe(id);
        if(existe) {
            throw new ExcepcionDuplicidad(MENSAJE_EL_PAQUETE_YA_EXISTE);
        }
    }
}

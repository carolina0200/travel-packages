package com.ceiba.paquete.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioActualizarPaquete {

    private static final String EL_PAQUETE_NO_EXISTE = "El paquete no existe en el sistema";

    private final RepositorioPaquete repositorioPaquete;

    public ServicioActualizarPaquete(RepositorioPaquete repositorioPaquete) {
        this.repositorioPaquete = repositorioPaquete;
    }

    public void ejecutar(Paquete paquete) {
        validarExistenciaPrevia(paquete.getId());
        this.repositorioPaquete.actualizar(paquete);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioPaquete.existe(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_PAQUETE_NO_EXISTE);
        }
    }
}

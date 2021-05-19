package com.ceiba.paquete.servicio;

import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioActualizarPaquete {

    private final RepositorioPaquete repositorioPaquete;

    public ServicioActualizarPaquete(RepositorioPaquete repositorioPaquete) {
        this.repositorioPaquete = repositorioPaquete;
    }

    public void ejecutar(Paquete paquete) {
        this.repositorioPaquete.actualizar(paquete);
    }
}

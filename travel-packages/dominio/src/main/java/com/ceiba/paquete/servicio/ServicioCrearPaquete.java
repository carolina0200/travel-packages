package com.ceiba.paquete.servicio;

import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioCrearPaquete {
    private final RepositorioPaquete repositorioPaquete;

    public ServicioCrearPaquete(RepositorioPaquete repositorioPaquete) {
        this.repositorioPaquete = repositorioPaquete;
    }

    public Long ejecutar(Paquete paquete) {
        return this.repositorioPaquete.crear(paquete);
    }
}

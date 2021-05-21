package com.ceiba.paquete.puerto.repositorio;

import com.ceiba.paquete.modelo.entidad.Paquete;

public interface RepositorioPaquete {
    /**
     * Permite crear un paquete de viajes
     * @param paquete
     * @return el id generado
     */
    Long crear(Paquete paquete);

    /**
     * Permite actualizar un paquete de viajes
     * @param paquete
     */
    void actualizar(Paquete paquete);

    boolean existe(Long id);

    Double obtenerPrecio(Long id);
}

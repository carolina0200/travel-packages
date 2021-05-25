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

    /**
     * Permite verificar existencia de un paquete de viajes
     * @param id
     */
    boolean existe(Long id);

    /**
     * Permite obtener un paquete de viajes
     * @param id
     */
    Double obtenerPrecio(Long id);

    /**
     * Permite sumar cupos a un paquete de viajes
     * @param id
     * @param cupos
     */
    void sumarCupos(Long id, Long cupos);

    /**
     * Permite restar cupos a un paquete de viajes
     * @param id
     * @param cupos
     */
    void restarCupos(Long id, Long cupos);
}

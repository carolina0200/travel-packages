package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {
    /**
     * Permite crear una compra
     * @param compra
     * @return el id generado
     */
    Long crear(Compra compra);

    /**
     * Permite actualizar una compra
     * @param compra
     */
    void actualizar(Compra compra);
}

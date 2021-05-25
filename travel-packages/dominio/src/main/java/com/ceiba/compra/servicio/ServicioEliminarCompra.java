package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioEliminarCompra {
    private final RepositorioCompra repositorioCompra;
    private final RepositorioPaquete repositorioPaquete;

    public ServicioEliminarCompra(RepositorioCompra repositorioCompra, RepositorioPaquete repositorioPaquete) {
        this.repositorioCompra = repositorioCompra;
        this.repositorioPaquete = repositorioPaquete;
    }

    public void ejecutar(Long id, Long idPaquete, Long cuposASumar) {
        this.repositorioCompra.eliminar(id);
        this.repositorioPaquete.sumarCupos(idPaquete, cuposASumar);
    }
}

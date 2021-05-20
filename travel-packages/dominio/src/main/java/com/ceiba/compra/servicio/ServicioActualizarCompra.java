package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarCompra {
    private static final String LA_COMPRA_NO_EXISTE = "La compra no existe en el sistema";
    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);
        this.repositorioCompra.actualizar(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId(),compra.getIdPaquete());
        if(!existe) {
            throw new ExcepcionSinDatos(LA_COMPRA_NO_EXISTE);
        }
    }
}

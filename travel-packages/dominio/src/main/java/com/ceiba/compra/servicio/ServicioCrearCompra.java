package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;

public class ServicioCrearCompra {

    private static final String MENSAJE_LA_COMPRA_YA_EXISTE = "La compra ya existe en el sistema";
    private static final String MENSAJE_PAQUETE_NO_EXISTE = "El paquete no existe en el sistema";

    private final RepositorioCompra repositorioCompra;
    private final RepositorioPaquete repositorioPaquete;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioPaquete repositorioPaquete) {
        this.repositorioPaquete = repositorioPaquete;
        this.repositorioCompra = repositorioCompra;
    }

    public Long ejecutar(Compra compra) {
        validarExistenciaPaquete(compra.getIdPaquete());
        validarExistenciaPrevia(compra);
        return this.repositorioCompra.crear(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId(),compra.getIdPaquete());
        if(existe) {
            throw new ExcepcionDuplicidad(MENSAJE_LA_COMPRA_YA_EXISTE);
        }
    }

    private void validarExistenciaPaquete(Long idPaquete) {
        boolean existe = this.repositorioPaquete.existe(idPaquete);
        if(!existe) {
            throw new ExcepcionSinDatos(MENSAJE_PAQUETE_NO_EXISTE);
        }
    }
}

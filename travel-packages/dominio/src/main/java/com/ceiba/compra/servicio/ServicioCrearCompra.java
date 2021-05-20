package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.modelo.dto.DtoPaquete;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import static com.ceiba.dominio.ValidadorArgumento.*;

public class ServicioCrearCompra {

    private static final String MENSAJE_LA_COMPRA_YA_EXISTE = "La compra ya existe en el sistema";
    private static final String MENSAJE_PAQUETE_NO_EXISTE = "El paquete no existe en el sistema";
    private static final String MENSAJE_VALIDAR_FECHA_HASTA_PAQUETE = "La fecha limite de compra para el paquete ya paso";
    private static final String MENSAJE_EXEDE_LIMITE_CUPOS = "La compra exede el limite de cupos";
    private static final String MENSAJE_NO_CONINCIDEN_DIAS_CON_FECHAS = "La fecha de regreso no coincide con los días de duración del paquete";

    private final RepositorioCompra repositorioCompra;
    private final RepositorioPaquete repositorioPaquete;
    private final DaoPaquete daoPaquete;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioPaquete repositorioPaquete, DaoPaquete daoPaquete) {
        this.repositorioPaquete = repositorioPaquete;
        this.repositorioCompra = repositorioCompra;
        this.daoPaquete = daoPaquete;
    }

    public Long ejecutar(Compra compra) {
        validarExistenciaPaquete(compra.getIdPaquete());
        validarExistenciaPrevia(compra);
        DtoPaquete paquete = daoPaquete.obtener(compra.getIdPaquete());
        validarMenor(compra.getFechaCompra(), paquete.getFechaHasta(), MENSAJE_VALIDAR_FECHA_HASTA_PAQUETE);
        validarMenor(compra.getNumeroAdultos() + compra.getNumeroMenores(), paquete.getCupos(), String.format(MENSAJE_EXEDE_LIMITE_CUPOS, paquete.getCupos()));
        validarIgual((double) compra.getFechaIda().plusDays(paquete.getDias()).getDayOfMonth(), (double) compra.getFechaRegreso().getDayOfMonth(), MENSAJE_NO_CONINCIDEN_DIAS_CON_FECHAS);
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

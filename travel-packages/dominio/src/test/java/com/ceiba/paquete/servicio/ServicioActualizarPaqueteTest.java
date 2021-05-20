package com.ceiba.paquete.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import com.ceiba.paquete.servicio.testdatabuilder.PaqueteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarPaqueteTest {

    @Test
    public void validarPaqueteExistenciaPreviaTest() {
        // arrange
        Paquete paquete = new PaqueteTestDataBuilder().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPaquete servicioActualizarPaquete = new ServicioActualizarPaquete(repositorioPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPaquete.ejecutar(paquete), ExcepcionSinDatos.class,"El paquete no existe en el sistema");
    }
}

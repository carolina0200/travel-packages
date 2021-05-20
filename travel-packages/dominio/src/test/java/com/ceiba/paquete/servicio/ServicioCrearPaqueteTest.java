package com.ceiba.paquete.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import com.ceiba.paquete.servicio.testdatabuilder.PaqueteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPaqueteTest {
    @Test
    public void validarPaqueteExistenciaPreviaTest() {
        // arrange
        Paquete paquete = new PaqueteTestDataBuilder().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearPaquete servicioCrearPaquete = new ServicioCrearPaquete(repositorioPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPaquete.ejecutar(paquete), ExcepcionDuplicidad.class,"El paquete ya existe en el sistema");
    }
}

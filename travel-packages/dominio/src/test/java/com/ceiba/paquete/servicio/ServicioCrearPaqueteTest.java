package com.ceiba.paquete.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import com.ceiba.paquete.servicio.testdatabuilder.PaqueteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPaqueteTest {
    private static final Long ID_RESPUESTA = 1L;
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

    @Test
    public void validarPaqueteExistenciaPreviaFalseTest() {
        // arrange
        Paquete paquete = new PaqueteTestDataBuilder().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPaquete.crear(paquete)).thenReturn(ID_RESPUESTA);
        ServicioCrearPaquete servicioCrearPaquete = new ServicioCrearPaquete(repositorioPaquete);
        // act - assert
        assertEquals (ID_RESPUESTA, servicioCrearPaquete.ejecutar(paquete));
    }
}

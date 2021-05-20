package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ServicioActualizarCompraTest {

    @Test
    public void validarCompraExistenciaPreviaTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(compra), ExcepcionSinDatos.class,"La compra no existe en el sistema");
    }

    @Test
    public void validarCompraExistenciaPreviaTrueTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        doNothing().when(repositorioCompra).actualizar(compra);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // act
        servicioActualizarCompra.ejecutar(compra);
        // assert
        verify(repositorioCompra, times(1)).actualizar(compra);
    }
}

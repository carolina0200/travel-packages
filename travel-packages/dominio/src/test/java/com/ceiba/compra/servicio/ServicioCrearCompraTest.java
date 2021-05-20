package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCompraTest {
    @Test
    public void validarFormatoCorreoTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conCorreo("micorreo.com");
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorInvalido.class, "El correo debe seguir el siguiente formato (correo@servicio.com)");
    }

    @Test
    public void validarVigenciaTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conVigencia("F");
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorInvalido.class, "En vigencia va A para Activa e I para Inactiva");
    }

    @Test
    public void validarExistenciaPaqueteTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioPaquete, daoPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionSinDatos.class,"El paquete no existe en el sistema");
    }

    @Test
    public void validarCompraExistenciaPreviaTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioPaquete, daoPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class,"La compra ya existe en el sistema");
    }


}

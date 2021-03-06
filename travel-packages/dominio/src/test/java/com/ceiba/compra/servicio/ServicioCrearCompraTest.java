package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.paquete.modelo.dto.DtoPaquete;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import com.ceiba.paquete.servicio.testdatabuilder.PaqueteTestDataBuilder;
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

    @Test
    public void validarCompraEstadoPaqueteTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conFechaIdaSabado().build();
        DtoPaquete paquete = new PaqueteTestDataBuilder().conEstadoInactivo().buildDto();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(daoPaquete.obtener(Mockito.anyLong())).thenReturn(paquete);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioPaquete, daoPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionValorInvalido.class,"El paquete esta inactivo por ahora");
    }

    @Test
    public void validarCompraCuposPaqueteTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conNumeroAdultos(5L).conNumeroMenores(2L).conFechaIdaSabado().build();
        DtoPaquete paquete = new PaqueteTestDataBuilder().conCupos(4L).buildDto();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(daoPaquete.obtener(Mockito.anyLong())).thenReturn(paquete);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioPaquete, daoPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionValorInvalido.class,"La compra exede el limite de cupos");
    }

    @Test
    public void validarCompraRegresoTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conNumeroAdultos(2L).conNumeroMenores(2L).conFechaIdaSabado().build();
        DtoPaquete paquete = new PaqueteTestDataBuilder().conCupos(4L).buildDto();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(daoPaquete.obtener(Mockito.anyLong())).thenReturn(paquete);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioPaquete, daoPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionValorInvalido.class,"La fecha de regreso no coincide con los d??as de duraci??n del paquete");
    }


}

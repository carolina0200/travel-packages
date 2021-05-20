package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import com.ceiba.paquete.servicio.testdatabuilder.PaqueteTestDataBuilder;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

public class ServicioCalcularPrecioCompraTest {

    @Test
    public void validarCompraExistenciaPaqueteTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCalcularPrecioCompra servicioCalcularPrecioCompra = new ServicioCalcularPrecioCompra(repositorioPaquete, daoPaquete);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCalcularPrecioCompra.ejecutar(compra), ExcepcionSinDatos.class,"El paquete no existe en el sistema");
    }

    @Test
    @DisplayName("Regla 1: Para sabados y domingos 10% más en el valor del paquete")
    public void validarCalcularPrecioReglaUnoTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conNumeroAdultos(2L).conNumeroMenores(0L).conFechaIdaSabado().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPaquete.obtener(Mockito.anyLong())).thenReturn(new PaqueteTestDataBuilder().buildDto());
        ServicioCalcularPrecioCompra servicioCalcularPrecioCompra = new ServicioCalcularPrecioCompra(repositorioPaquete, daoPaquete);
        // act - assert
        assertEquals (2200000, servicioCalcularPrecioCompra.ejecutar(compra).doubleValue());
    }

    @Test
    @DisplayName("Regla 2: Para niños menores en semana -50% en el valor del paquete por cada uno")
    public void validarCalcularPrecioReglaDosTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conNumeroAdultos(2L).conNumeroMenores(2L).conFechaIdaSemana().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPaquete.obtener(Mockito.anyLong())).thenReturn(new PaqueteTestDataBuilder().buildDto());
        ServicioCalcularPrecioCompra servicioCalcularPrecioCompra = new ServicioCalcularPrecioCompra(repositorioPaquete, daoPaquete);
        // act - assert
        assertEquals (3000000, servicioCalcularPrecioCompra.ejecutar(compra).doubleValue());
    }

    @Test
    @DisplayName("Regla 3: Para compras con más de 5 personas -20% en el valor")
    public void validarCalcularPrecioReglaTresTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conNumeroAdultos(5L).conNumeroMenores(0L).conFechaIdaSemana().build();
        RepositorioPaquete repositorioPaquete = Mockito.mock(RepositorioPaquete.class);
        DaoPaquete daoPaquete = Mockito.mock(DaoPaquete.class);
        Mockito.when(repositorioPaquete.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPaquete.obtener(Mockito.anyLong())).thenReturn(new PaqueteTestDataBuilder().buildDto());
        ServicioCalcularPrecioCompra servicioCalcularPrecioCompra = new ServicioCalcularPrecioCompra(repositorioPaquete, daoPaquete);
        // act - assert
        assertEquals (4000000, servicioCalcularPrecioCompra.ejecutar(compra).doubleValue());
    }
}

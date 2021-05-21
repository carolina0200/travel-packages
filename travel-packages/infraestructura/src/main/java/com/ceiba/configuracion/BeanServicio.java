package com.ceiba.configuracion;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.ServicioCalcularPrecioCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import com.ceiba.paquete.servicio.ServicioActualizarPaquete;
import com.ceiba.paquete.servicio.ServicioCrearPaquete;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioActualizarCompra servicioActualizarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioActualizarCompra(repositorioCompra);
    }

    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioPaquete repositorioPaquete, DaoPaquete daoPaquete) {
        return new ServicioCrearCompra(repositorioCompra, repositorioPaquete, daoPaquete);
    }

    @Bean
    public ServicioCalcularPrecioCompra servicioCalcularPrecioCompra(RepositorioPaquete repositorioPaquete) {
        return new ServicioCalcularPrecioCompra(repositorioPaquete);
    }

    @Bean
    public ServicioActualizarPaquete servicioActualizarPaquete(RepositorioPaquete repositorioPaquete) {
        return new ServicioActualizarPaquete(repositorioPaquete);
    }

    @Bean
    public ServicioCrearPaquete servicioCrearPaquete(RepositorioPaquete repositorioPaquete) {
        return new ServicioCrearPaquete(repositorioPaquete);
    }

}

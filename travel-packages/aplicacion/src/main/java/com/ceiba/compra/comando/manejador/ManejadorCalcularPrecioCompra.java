package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.ServicioCalcularPrecioCompra;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCalcularPrecioCompra implements ManejadorComandoRespuesta<ComandoCompra, ComandoRespuesta<Double>> {

    private final FabricaCompra fabricaCompra;
    private final ServicioCalcularPrecioCompra servicioCalcularPrecioCompra;

    public ManejadorCalcularPrecioCompra(FabricaCompra fabricaCompra, ServicioCalcularPrecioCompra servicioCalcularPrecioCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioCalcularPrecioCompra = servicioCalcularPrecioCompra;
    }

    @Override
    public ComandoRespuesta<Double> ejecutar(ComandoCompra comando) {
        Compra compra = this.fabricaCompra.crear(comando);
        return new ComandoRespuesta<>(servicioCalcularPrecioCompra.ejecutar(compra));
    }
}

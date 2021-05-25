package com.ceiba.compra.comando.manejador;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCompra implements ManejadorComando<ComandoCompra> {
    private final ServicioEliminarCompra servicioEliminarCompra;

    public ManejadorEliminarCompra(ServicioEliminarCompra servicioEliminarCompra) {
        this.servicioEliminarCompra = servicioEliminarCompra;
    }

    @Override
    public void ejecutar(ComandoCompra comando) {
        Long cuposASumar = comando.getNumeroAdultos() + comando.getNumeroMenores();
        this.servicioEliminarCompra.ejecutar(comando.getId(), comando.getIdPaquete(), cuposASumar);
    }
}

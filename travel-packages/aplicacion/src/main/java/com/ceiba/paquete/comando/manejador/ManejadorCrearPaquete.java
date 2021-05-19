package com.ceiba.paquete.comando.manejador;

import com.ceiba.paquete.comando.ComandoPaquete;
import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.paquete.comando.fabrica.FabricaPaquete;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.servicio.ServicioCrearPaquete;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPaquete implements ManejadorComandoRespuesta<ComandoPaquete, ComandoRespuesta<Long>> {
    private final FabricaPaquete fabricaPaquete;
    private final ServicioCrearPaquete servicioCrearPaquete;

    public ManejadorCrearPaquete(FabricaPaquete fabricaPaquete, ServicioCrearPaquete servicioCrearPaquete) {
        this.fabricaPaquete = fabricaPaquete;
        this.servicioCrearPaquete = servicioCrearPaquete;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPaquete comandoPaquete) {
        Paquete paquete = this.fabricaPaquete.crear(comandoPaquete);
        return new ComandoRespuesta<>(this.servicioCrearPaquete.ejecutar(paquete));
    }
}

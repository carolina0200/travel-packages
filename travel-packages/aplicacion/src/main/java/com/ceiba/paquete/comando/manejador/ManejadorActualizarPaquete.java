package com.ceiba.paquete.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paquete.comando.ComandoPaquete;
import com.ceiba.paquete.comando.fabrica.FabricaPaquete;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.servicio.ServicioActualizarPaquete;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPaquete implements ManejadorComando<ComandoPaquete> {
    private final FabricaPaquete fabricaPaquete;
    private final ServicioActualizarPaquete servicioActualizarPaquete;

    public ManejadorActualizarPaquete(FabricaPaquete fabricaPaquete, ServicioActualizarPaquete servicioActualizarPaquete) {
        this.fabricaPaquete = fabricaPaquete;
        this.servicioActualizarPaquete = servicioActualizarPaquete;
    }

    public void ejecutar(ComandoPaquete comandoPaquete) {
        Paquete paquete = this.fabricaPaquete.crear(comandoPaquete);
        this.servicioActualizarPaquete.ejecutar(paquete);
    }
}

package com.ceiba.paquete.comando.fabrica;

import com.ceiba.paquete.comando.ComandoPaquete;
import com.ceiba.paquete.modelo.entidad.Paquete;
import org.springframework.stereotype.Component;

@Component
public class FabricaPaquete {

    public Paquete crear(ComandoPaquete comandoPaquete) {
        return new Paquete(
                comandoPaquete.getId(),
                comandoPaquete.getPrecio(),
                comandoPaquete.getEstado(),
                comandoPaquete.getCiudad(),
                comandoPaquete.getHotel(),
                comandoPaquete.getDescripcion(),
                comandoPaquete.getCupos(),
                comandoPaquete.getDias(),
                comandoPaquete.getFechaCreacion(),
                comandoPaquete.getFechaHasta()
        );
    }
}

package com.ceiba.paquete.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.paquete.comando.ComandoPaquete;
import com.ceiba.paquete.comando.manejador.ManejadorActualizarPaquete;
import com.ceiba.paquete.comando.manejador.ManejadorCrearPaquete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paquetes")
@Api(tags = { "Controlador comando paquete"})
public class ComandoControladorPaquete {

    private final ManejadorActualizarPaquete manejadorActualizarPaquete;
    private final ManejadorCrearPaquete manejadorCrearPaquete;

    public ComandoControladorPaquete(ManejadorActualizarPaquete manejadorActualizarPaquete, ManejadorCrearPaquete manejadorCrearPaquete) {
        this.manejadorActualizarPaquete = manejadorActualizarPaquete;
        this.manejadorCrearPaquete = manejadorCrearPaquete;
    }

    @PostMapping
    @ApiOperation("Crear paquete")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPaquete comandoPaquete) {
        return manejadorCrearPaquete.ejecutar(comandoPaquete);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar paquete")
    public void actualizar(@RequestBody ComandoPaquete comandoPaquete, @PathVariable Long id) {
        comandoPaquete.setId(id);
        manejadorActualizarPaquete.ejecutar(comandoPaquete);
    }
}

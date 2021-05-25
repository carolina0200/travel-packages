package com.ceiba.paquete.controlador;

import com.ceiba.paquete.consulta.ManejadorListarPaquetes;
import com.ceiba.paquete.modelo.dto.DtoPaquete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/paquetes")
@Api(tags={"Controlador consulta paquete"})
public class ConsultaControladorPaquete {

    private final ManejadorListarPaquetes manejadorListarPaquetes;

    public ConsultaControladorPaquete(ManejadorListarPaquetes manejadorListarPaquetes) {
        this.manejadorListarPaquetes = manejadorListarPaquetes;
    }

    @GetMapping
    @ApiOperation("Listar paquetes")
    public List<DtoPaquete> listar() {
        return this.manejadorListarPaquetes.ejecutar();
    }
}

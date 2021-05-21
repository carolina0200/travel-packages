package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.compra.comando.manejador.ManejadorCalcularPrecioCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
@Api(tags = { "Controlador comando compras"})
public class ComandoControladorCompra {

    private final ManejadorActualizarCompra manejadorActualizarCompra;
    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorCalcularPrecioCompra manejadorCalcularPrecioCompra;

    public ComandoControladorCompra(ManejadorActualizarCompra manejadorActualizarCompra, ManejadorCrearCompra manejadorCrearCompra, ManejadorCalcularPrecioCompra manejadorCalcularPrecioCompra) {
        this.manejadorActualizarCompra = manejadorActualizarCompra;
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorCalcularPrecioCompra = manejadorCalcularPrecioCompra;
    }

    @PostMapping
    @ApiOperation("Crear compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCrearCompra.ejecutar(comandoCompra);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar compra")
    public void actualizar(@RequestBody ComandoCompra comandoCompra, @PathVariable Long id) {
        comandoCompra.setId(id);
        manejadorActualizarCompra.ejecutar(comandoCompra);
    }

    @PostMapping(value="/calcular-precio")
    @ApiOperation("Calcular valor compra")
    public ComandoRespuesta<Double> calcularPrecio(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCalcularPrecioCompra.ejecutar(comandoCompra);
    }
}

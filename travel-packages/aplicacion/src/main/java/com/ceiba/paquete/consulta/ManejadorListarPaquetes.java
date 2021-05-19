package com.ceiba.paquete.consulta;

import com.ceiba.paquete.modelo.dto.DtoPaquete;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPaquetes {

    private final DaoPaquete daoPaquete;

    public ManejadorListarPaquetes(DaoPaquete daoPaquete){
        this.daoPaquete = daoPaquete;
    }

    public List<DtoPaquete> ejecutar(){ return this.daoPaquete.listar(); }
}

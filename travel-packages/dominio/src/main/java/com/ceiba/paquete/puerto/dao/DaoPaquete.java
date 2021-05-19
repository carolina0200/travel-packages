package com.ceiba.paquete.puerto.dao;

import com.ceiba.paquete.modelo.dto.DtoPaquete;

import java.util.List;

public interface DaoPaquete {
    /**
     * Permite listar paquetes
     * @return los paquetes
     */
    List<DtoPaquete> listar();
}

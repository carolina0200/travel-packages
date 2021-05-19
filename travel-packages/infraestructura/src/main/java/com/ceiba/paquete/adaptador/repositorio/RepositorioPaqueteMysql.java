package com.ceiba.paquete.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPaqueteMysql implements RepositorioPaquete {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="paquete", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="paquete", value="actualizar")
    private static String sqlActualizar;

    public RepositorioPaqueteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Paquete paquete) {
        return this.customNamedParameterJdbcTemplate.crear(paquete, sqlCrear);
    }

    @Override
    public void actualizar(Paquete paquete) {
        this.customNamedParameterJdbcTemplate.actualizar(paquete, sqlActualizar);
    }
}

package com.ceiba.paquete.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paquete.modelo.dto.DtoPaquete;
import com.ceiba.paquete.puerto.dao.DaoPaquete;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPaqueteMysql implements DaoPaquete {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="paquete", value="listar")
    private static String sqlListar;

    public DaoPaqueteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPaquete> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPaquete());
    }
}

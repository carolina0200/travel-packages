package com.ceiba.paquete.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paquete.modelo.entidad.Paquete;
import com.ceiba.paquete.puerto.repositorio.RepositorioPaquete;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPaqueteMysql implements RepositorioPaquete {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="paquete", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="paquete", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="paquete", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="paquete", value="obtenerPrecio")
    private static String sqlObtenerPrecio;

    @SqlStatement(namespace="paquete", value="sumarCupos")
    private static String sqlSumarCupos;

    @SqlStatement(namespace="paquete", value="restarCupos")
    private static String sqlRestarCupos;

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

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public Double obtenerPrecio(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPrecio, paramSource, Double.class);
    }

    @Override
    public void sumarCupos(Long id, Long cupos) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("cupos", cupos);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlSumarCupos, paramSource);
    }

    @Override
    public void restarCupos(Long id, Long cupos) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("cupos", cupos);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlRestarCupos, paramSource);
    }
}

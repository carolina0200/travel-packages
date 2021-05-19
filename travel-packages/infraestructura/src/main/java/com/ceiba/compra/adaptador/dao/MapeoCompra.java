package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {
    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new DtoCompra (
                resultSet.getLong("id"),
                resultSet.getLong("id_paquete"),
                resultSet.getLong("valor"),
                resultSet.getString("vigencia"),
                resultSet.getString("identificacion"),
                resultSet.getString("nombre"),
                resultSet.getString("correo"),
                resultSet.getLong("numero_menores"),
                resultSet.getLong("numero_adultos"),
                extraerLocalDateTime(resultSet, "fecha_compra"),
                extraerLocalDateTime(resultSet, "fecha_ida"),
                extraerLocalDateTime(resultSet, "fecha_regreso")
        );
    }
}

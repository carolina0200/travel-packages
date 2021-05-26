package com.ceiba.paquete.adaptador.dao;

import com.ceiba.paquete.modelo.dto.DtoPaquete;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPaquete implements RowMapper<DtoPaquete>, MapperResult {
    @Override
    public DtoPaquete mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new DtoPaquete(
                resultSet.getLong("id"),
                resultSet.getDouble("precio"),
                resultSet.getString("estado"),
                resultSet.getString("ciudad"),
                resultSet.getString("hotel"),
                resultSet.getString("descripcion"),
                resultSet.getLong("cupos"),
                resultSet.getLong("dias"),
                extraerLocalDateTime(resultSet, "fecha_creacion")
        );
    }
}

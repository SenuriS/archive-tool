package com.fg.archive.tool.source.dao.rowMapper;

import com.fg.archive.tool.common.model.SourceDBTableSchema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SourceDBTableSchemaRowMapper implements RowMapper<SourceDBTableSchema> {

    @Override
    public SourceDBTableSchema mapRow(ResultSet rs, int rowNum) throws SQLException {
       SourceDBTableSchema sourceDBTableSchema = new SourceDBTableSchema();
       sourceDBTableSchema.setField(rs.getString("Field"));
       sourceDBTableSchema.setType(rs.getString("Type"));
       sourceDBTableSchema.setKey(rs.getString("Key"));
       return sourceDBTableSchema;
    }
}

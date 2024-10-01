package com.fg.archive.tool.source.dao.Impl;

import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.source.dao.SourceDBTableSchemaDao;
import com.fg.archive.tool.source.dao.rowMapper.SourceDBTableSchemaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SourceDBTableSchemaDaoImpl implements SourceDBTableSchemaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

   @Override
    public List<SourceDBTableSchema> getArchiveTableSourceSchema(String tableName) {

        String sql = "desc "+tableName;
        return jdbcTemplate.query(sql, new SourceDBTableSchemaRowMapper());

    }
}

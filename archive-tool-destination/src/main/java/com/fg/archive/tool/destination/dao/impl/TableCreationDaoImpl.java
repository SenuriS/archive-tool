package com.fg.archive.tool.destination.dao.impl;

import com.fg.archive.tool.destination.dao.TableCreationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TableCreationDaoImpl implements TableCreationDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createTable(String createScript) {
        jdbcTemplate.execute(createScript);
    }

    @Override
    public void dropTable(String tableName) {
        String sql = "DROP TABLE `"+tableName+"`;";
        jdbcTemplate.execute(sql);
    }
}

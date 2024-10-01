package com.fg.archive.tool.destination.dao.impl;

import com.fg.archive.tool.destination.dao.DataArchiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DataArchiveDaoImpl implements DataArchiveDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String archivedDataMinValue(String srcTable, String srcColumn, String startDate, String endDate) {
        String sql = "SELECT MIN("+srcColumn+") FROM "+srcTable+" WHERE "+srcColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public String archivedDataMaxValue(String srcTable, String srcColumn, String startDate, String endDate) {
        String sql = "SELECT MAX("+srcColumn+") FROM "+srcTable+" WHERE "+srcColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public Integer archiveDataRowCount(String srcTable, String srcColumn, String startDate, String endDate) {
        String sql = "SELECT COUNT(*) FROM "+srcTable+" WHERE "+srcColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void archiveData(String srcTable,String srcColumn, String destTable, String startDate, String endDate) {

        String sql = "INSERT INTO "+destTable+" SELECT * FROM "+srcTable+" WHERE "+srcColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        jdbcTemplate.execute(sql);

    }
}

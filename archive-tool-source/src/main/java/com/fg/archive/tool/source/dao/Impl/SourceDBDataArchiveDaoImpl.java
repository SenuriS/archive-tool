package com.fg.archive.tool.source.dao.Impl;

import com.fg.archive.tool.source.dao.SourceDBDataArchiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SourceDBDataArchiveDaoImpl implements SourceDBDataArchiveDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String archiveTableMinValue(String archiveTable, String archiveColumn) {
       String sql = "SELECT MIN("+archiveColumn+") FROM "+archiveTable+";";
      return jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public String archiveTableMinValue(String archiveTable, String archiveColumn, String startDate, String endDate) {
        String sql = "SELECT MIN("+archiveColumn+") FROM "+archiveTable+" WHERE "+archiveColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public String archiveTableMaxValue(String archiveTable, String archiveColumn) {
        String sql = "SELECT MAX("+archiveColumn+") FROM "+archiveTable+";";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public String archiveTableMaxValue(String archiveTable, String archiveColumn, String startDate, String endDate) {
        String sql = "SELECT MAX("+archiveColumn+") FROM "+archiveTable+" WHERE "+archiveColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public Long archiveTableRowCount(String archiveTable) {
       String sql = "SELECT COUNT(*) FROM "+archiveTable+";";
       return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public Long archiveTableRowCount(String archiveTable,String archiveColumn, String startDate, String endDate) {
        String sql = "SELECT COUNT(*) FROM "+archiveTable+" WHERE "+archiveColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public void deleteFromSourceTable(String archiveTable, String archiveColumn, String startDate, String endDate) {
        String sql = "DELETE FROM "+archiveTable+" WHERE "+archiveColumn+" " +
                "BETWEEN '"+startDate+"' AND '"+endDate+"';";
        jdbcTemplate.execute(sql);
    }


}

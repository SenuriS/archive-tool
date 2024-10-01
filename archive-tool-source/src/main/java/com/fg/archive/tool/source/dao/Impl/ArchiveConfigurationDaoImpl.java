package com.fg.archive.tool.source.dao.Impl;

import com.fg.archive.tool.source.dao.ArchiveConfigurationDao;
import com.fg.archive.tool.source.dao.rowMapper.ArchiveConfigurationRowMapper;
import com.fg.archive.tool.common.model.ArchiveConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArchiveConfigurationDaoImpl implements ArchiveConfigurationDao {

    @Autowired
   JdbcTemplate jdbcTemplate;

    @Override
    public List<ArchiveConfiguration> listArchiveConfigurationByStatus(boolean enabled) {
        String sql = "SELECT * FROM bank_suite_archive_configuration WHERE archive_enabled = ? ";
        return jdbcTemplate.query(sql, new ArchiveConfigurationRowMapper(), enabled);
    }

    @Override
    public ArchiveConfiguration getArchiveConfigurationId(int id) {
        String sql = "SELECT * FROM bank_suite_archive_configuration WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new ArchiveConfigurationRowMapper(), id);
    }
}





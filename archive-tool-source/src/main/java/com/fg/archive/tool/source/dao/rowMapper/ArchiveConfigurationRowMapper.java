package com.fg.archive.tool.source.dao.rowMapper;

import com.fg.archive.tool.common.model.ArchiveConfiguration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArchiveConfigurationRowMapper implements RowMapper<ArchiveConfiguration> {
    @Override
    public ArchiveConfiguration mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArchiveConfiguration archiveConfiguration = new ArchiveConfiguration();
        archiveConfiguration.setArchiveTableId(rs.getInt("id"));
        archiveConfiguration.setTableName(rs.getString("table_name"));
        archiveConfiguration.setTableDisplayName(rs.getString("table_display_name"));
        archiveConfiguration.setArchiveColumn(rs.getString("archive_column"));
        archiveConfiguration.setArchiveColumnType(rs.getString("archive_column_type"));
        archiveConfiguration.setArchiveColumnDisplayName(rs.getString("archive_column_display_name"));
        archiveConfiguration.setArchiveEnabled(rs.getBoolean("archive_enabled"));
        return archiveConfiguration;
    }
}

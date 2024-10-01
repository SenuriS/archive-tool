package com.fg.archive.tool.destination.dao.rowMapper;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArchiveDataLogHistoryMapper implements RowMapper<ArchiveDataLogHistory> {
    @Override
    public ArchiveDataLogHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArchiveDataLogHistory archiveDataLogHistory = new ArchiveDataLogHistory();
        archiveDataLogHistory.setLogID(rs.getInt("log_id"));
        archiveDataLogHistory.setArchiveSourceTableID(rs.getInt("archive_source_table_id"));
        archiveDataLogHistory.setArchiveDestTableName(rs.getString("archive_dest_table_name"));
        archiveDataLogHistory.setArchiveColumn(rs.getString("archive_column"));
        archiveDataLogHistory.setStartValue(rs.getString("start_value"));
        archiveDataLogHistory.setEndValue(rs.getString("end_value"));
        archiveDataLogHistory.setArchivedRowCount(rs.getInt("archived_record_count"));
        archiveDataLogHistory.setArchiveMinValue(rs.getString("archived_min_value"));
        archiveDataLogHistory.setArchivedMaxValue(rs.getString("archived_max_value"));

        return archiveDataLogHistory;

    }
}

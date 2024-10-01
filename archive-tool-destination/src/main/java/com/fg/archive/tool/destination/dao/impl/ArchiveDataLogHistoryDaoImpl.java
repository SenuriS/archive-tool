package com.fg.archive.tool.destination.dao.impl;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import com.fg.archive.tool.destination.dao.ArchiveDataLogHistoryDao;
import com.fg.archive.tool.destination.dao.rowMapper.ArchiveDataLogHistoryMapper;
import org.apache.catalina.valves.JsonAccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArchiveDataLogHistoryDaoImpl implements ArchiveDataLogHistoryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public ArchiveDataLogHistory getLastArchivedRecord() {
       String sql = "SELECT * FROM archive_table_history_log ORDER BY added_date desc limit 1";
       return jdbcTemplate.queryForObject(sql,new ArchiveDataLogHistoryMapper());
    }

    @Override
    public ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName) {
        String sql = "SELECT * FROM archive_table_history_log WHERE archive_dest_table_name = '"+tableName+"' ORDER BY added_date desc limit 1";
        return jdbcTemplate.queryForObject(sql,new ArchiveDataLogHistoryMapper());
    }

    @Override
    public List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName) {
        String sql = "SELECT * FROM archive_table_history_log WHERE archive_dest_table_name = '"+tableName+"' ORDER BY added_date";
        return jdbcTemplate.query(sql,new ArchiveDataLogHistoryMapper());
    }

    @Override
    public void createArchiveLogHistoryRecord(ArchiveDataLogHistory archiveDataLogHistory) {

        String sql = "INSERT INTO `archive_table_history_log` (`archive_source_table_id`, `archive_dest_table_name`, `archive_column`, `start_value`, `end_value`, `archived_record_count`, `archived_min_value`, `archived_max_value`,`added_by`) " +
                "VALUES ("+archiveDataLogHistory.getArchiveSourceTableID()+", '"+archiveDataLogHistory.getArchiveDestTableName()+"', '"+archiveDataLogHistory.getArchiveColumn()+"', '"+archiveDataLogHistory.getStartValue()+"', " +
                "'"+archiveDataLogHistory.getEndValue()+"', "+archiveDataLogHistory.getArchivedRowCount()+", '"+archiveDataLogHistory.getArchiveMinValue()+"', '"+archiveDataLogHistory.getArchivedMaxValue()+"', 'SYSTEM');";
        jdbcTemplate.execute(sql);

    }
}

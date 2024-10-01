package com.fg.archive.tool.destination.dao;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;

import java.util.List;

public interface ArchiveDataLogHistoryDao {

    ArchiveDataLogHistory getLastArchivedRecord();

    ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName);

    List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName);

    void createArchiveLogHistoryRecord(ArchiveDataLogHistory archiveDataLogHistory);
}

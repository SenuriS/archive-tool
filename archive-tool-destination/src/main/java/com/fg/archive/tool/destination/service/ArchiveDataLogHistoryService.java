package com.fg.archive.tool.destination.service;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;

import java.util.List;

public interface ArchiveDataLogHistoryService {

    ArchiveDataLogHistory getLastArchivedRecord();

    ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName);

    List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName);

}

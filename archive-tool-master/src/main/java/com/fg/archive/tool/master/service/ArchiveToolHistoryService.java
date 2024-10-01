package com.fg.archive.tool.master.service;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;

import java.util.List;

public interface ArchiveToolHistoryService {

    ArchiveDataLogHistory getLastArchivedRecord();

    ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName);

    List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName);


}

package com.fg.archive.tool.master.invoker;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;

import java.util.List;

public interface ArchiveToolHistoryInvoker {

    ArchiveDataLogHistory getLastArchivedRecord();

    ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName);

    List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName);
}

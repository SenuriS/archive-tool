package com.fg.archive.tool.master.service.impl;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import com.fg.archive.tool.master.invoker.ArchiveToolHistoryInvoker;
import com.fg.archive.tool.master.service.ArchiveToolHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveToolHistoryServiceImpl implements ArchiveToolHistoryService {

    @Autowired
    ArchiveToolHistoryInvoker archiveToolHistoryInvoker;

    @Override
    public ArchiveDataLogHistory getLastArchivedRecord() {
       return archiveToolHistoryInvoker.getLastArchivedRecord();
    }

    @Override
    public ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName) {
        return archiveToolHistoryInvoker.getLastArchivedRecordByTable(tableName);
    }

    @Override
    public List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName) {
        return archiveToolHistoryInvoker.getArchiveRecordHistoryByTable(tableName);
    }
}

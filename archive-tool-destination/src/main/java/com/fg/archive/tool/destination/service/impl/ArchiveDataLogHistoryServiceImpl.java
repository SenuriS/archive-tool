package com.fg.archive.tool.destination.service.impl;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import com.fg.archive.tool.destination.dao.ArchiveDataLogHistoryDao;
import com.fg.archive.tool.destination.service.ArchiveDataLogHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveDataLogHistoryServiceImpl implements ArchiveDataLogHistoryService {

    @Autowired
    ArchiveDataLogHistoryDao logHistoryDao;

    @Override
    public ArchiveDataLogHistory getLastArchivedRecord() {

        return logHistoryDao.getLastArchivedRecord();
    }

    @Override
    public ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName) {
        return logHistoryDao.getLastArchivedRecordByTable(tableName);
    }

    @Override
    public List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName) {
        return logHistoryDao.getArchiveRecordHistoryByTable(tableName);
    }

}

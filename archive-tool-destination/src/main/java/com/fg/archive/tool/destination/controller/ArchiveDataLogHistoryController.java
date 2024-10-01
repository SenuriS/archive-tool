package com.fg.archive.tool.destination.controller;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import com.fg.archive.tool.common.model.response.DataListResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.destination.service.ArchiveDataLogHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestAPIPath.ARCHIVE_TOOL_HISTORY)
public class ArchiveDataLogHistoryController {

    @Autowired
    ArchiveDataLogHistoryService archiveDataLogHistoryService;

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_HISTORY_LAST_RECORD)
    ArchiveDataLogHistory getLastArchivedRecord(){
        return archiveDataLogHistoryService.getLastArchivedRecord();
    }

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_HISTORY_LAST_RECORD_BY_TABLE)
    ArchiveDataLogHistory getLastArchivedRecord(@PathVariable String tableName){
        return archiveDataLogHistoryService.getLastArchivedRecordByTable(tableName);
    }

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_HISTORY_LAST_RECORD_LIST_BY_TABLE)
    DataListResponse<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(@PathVariable String tableName){
        return new DataListResponse<>(archiveDataLogHistoryService.getArchiveRecordHistoryByTable(tableName));
    }
}

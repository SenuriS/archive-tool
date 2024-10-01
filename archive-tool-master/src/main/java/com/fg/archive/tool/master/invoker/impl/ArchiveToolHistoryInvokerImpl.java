package com.fg.archive.tool.master.invoker.impl;

import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import com.fg.archive.tool.common.model.response.DataListResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.master.config.RestTemplateClass;
import com.fg.archive.tool.master.invoker.ArchiveToolHistoryInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArchiveToolHistoryInvokerImpl implements ArchiveToolHistoryInvoker {

    @Autowired
    RestTemplateClass restTemplate;

    @Value("${arch.tool.dest.service}")
    private String SERVICE_IP;

    String basePath = RestAPIPath.ARCHIVE_TOOL_HISTORY;

    String generateURLArchiveToolHistory(String sourceEndPoint){
        return this.SERVICE_IP+basePath+sourceEndPoint;
    }


    @Override
    public ArchiveDataLogHistory getLastArchivedRecord() {
        String url = generateURLArchiveToolHistory(RestAPIPath.ARCHIVE_TOOL_HISTORY_LAST_RECORD);
        ArchiveDataLogHistory response = restTemplate.getForObject(url,ArchiveDataLogHistory.class);
        return response;
    }

    @Override
    public ArchiveDataLogHistory getLastArchivedRecordByTable(String tableName) {
        String url = generateURLArchiveToolHistory(RestAPIPath.ARCHIVE_TOOL_HISTORY_LAST_RECORD_BY_TABLE);
        ArchiveDataLogHistory response = restTemplate.getForObject(url,ArchiveDataLogHistory.class, Map.of("tableName",tableName));
        return response;
    }

    @Override
    public List<ArchiveDataLogHistory> getArchiveRecordHistoryByTable(String tableName) {
        String url = generateURLArchiveToolHistory(RestAPIPath.ARCHIVE_TOOL_HISTORY_LAST_RECORD_LIST_BY_TABLE);
        DataListResponse<ArchiveDataLogHistory> response = restTemplate.getForObject(url,DataListResponse.class, Map.of("tableName",tableName));
        return response.getDataListResponse();
    }
}

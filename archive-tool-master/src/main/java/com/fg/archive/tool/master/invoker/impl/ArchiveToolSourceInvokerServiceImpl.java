package com.fg.archive.tool.master.invoker.impl;

import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import com.fg.archive.tool.common.model.response.DataListResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.master.config.RestTemplateClass;
import com.fg.archive.tool.master.invoker.ArchiveToolSourceInvokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArchiveToolSourceInvokerServiceImpl implements ArchiveToolSourceInvokerService {

    @Autowired
    RestTemplateClass restTemplate;

    @Value("${arch.tool.source.service}")
    private String SERVICE_IP;

    String basePath = RestAPIPath.ARCHIVE_TOOL_SOURCE_DATA_CONFIG;

    String generateURLArchiveConfig(String sourceEndPoint){
        return this.SERVICE_IP+basePath+sourceEndPoint;
    }

    @Override
    public List<ArchiveConfiguration> getArchiveTableListConfigurations(boolean enabled) {
        String url = generateURLArchiveConfig(RestAPIPath.ARCHIVE_TOOL_SOURCE_GET_TABLE_LIST);
        DataListResponse<ArchiveConfiguration> response = restTemplate.getForObject(url,DataListResponse.class, Map.of("enabled",enabled));
        return response.getDataListResponse();
    }

    @Override
    public ArchiveConfigurationResponse getArchiveConfigurationsById(int id) {
        String url = generateURLArchiveConfig(RestAPIPath.ARCHIVE_TOOL_SOURCE_GET_TABLE_BY_ID);
        ArchiveConfigurationResponse response = restTemplate.getForObject(url,ArchiveConfigurationResponse.class, Map.of("id",id));
        return response;
    }

    @Override
    public ArchiveDataInfo getArchiveTableDataInformation(ArchiveDataInfoRequest request) {
        String url = generateURLArchiveConfig(RestAPIPath.ARCHIVE_TOOL_SOURCE_ARCHIVE_DATA_INFO);
        ArchiveDataInfo archiveDataInfo = restTemplate.postForObject(url, request, ArchiveDataInfo.class);
        return archiveDataInfo;
    }

    @Override
    public List<SourceDBTableSchema> getSourceTableSchema(String tableName) {
        String url = generateURLArchiveConfig(RestAPIPath.ARCHIVE_TOOL_SOURCE_SCHEMA);
        DataListResponse<SourceDBTableSchema> response = restTemplate.getForObject(url,DataListResponse.class, Map.of("tableName",tableName));
        return response.getDataListResponse();
    }
}

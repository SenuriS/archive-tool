package com.fg.archive.tool.source.controller;


import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.common.model.response.DataListResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.source.service.SourceDataRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_DATA_CONFIG)
public class ArchiveDataConfigurationController {

    @Autowired
    SourceDataRetrieveService sourceDataRetrieveService;

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_GET_TABLE_LIST)
    public DataListResponse<ArchiveConfiguration> getArchiveTableListConfigurations(@PathVariable boolean enabled){
        return new DataListResponse<>(sourceDataRetrieveService.getArchiveTableListConfigurations(enabled));

    }

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_GET_TABLE_BY_ID)
    public ArchiveConfigurationResponse getArchiveConfigurationsById(@PathVariable int id){
        return sourceDataRetrieveService.getArchiveConfigurationsById(id);

    }

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_SCHEMA)
    public DataListResponse<SourceDBTableSchema> getSourceTableSchema(@PathVariable String tableName){
        return new DataListResponse<>(sourceDataRetrieveService.getSourceTableSchema(tableName));

    }

    @PostMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_ARCHIVE_DATA_INFO)
    @ResponseBody
    public ArchiveDataInfo getArchiveDataInfo(@RequestBody ArchiveDataInfoRequest request){
        return sourceDataRetrieveService.getArchiveTableDataInformation(request);

    }

    @PostMapping(RestAPIPath.ARCHIVE_SOURCE_TABLE_RECORD_DELETE)
    @ResponseBody
    public CommonResponse deleteFromSourceTable(@RequestBody ArchiveDataInfoRequest request){
        return sourceDataRetrieveService.deleteFromSourceTable(request);

    }

}

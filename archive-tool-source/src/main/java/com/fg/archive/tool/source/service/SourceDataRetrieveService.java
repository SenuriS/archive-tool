package com.fg.archive.tool.source.service;

import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import com.fg.archive.tool.common.model.response.CommonResponse;

import java.util.List;

public interface SourceDataRetrieveService {

    List<ArchiveConfiguration> getArchiveTableListConfigurations(boolean enabled);

    ArchiveConfigurationResponse getArchiveConfigurationsById(int id);

    ArchiveDataInfo getArchiveTableDataInformation(ArchiveDataInfoRequest request);

    List<SourceDBTableSchema> getSourceTableSchema(String tableName);

    CommonResponse deleteFromSourceTable(ArchiveDataInfoRequest request);
}

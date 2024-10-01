package com.fg.archive.tool.master.service;

import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;

import java.util.List;

public interface ArchiveToolSourceConfigurationsService {

  List<ArchiveConfiguration> getArchiveTableListConfigurations(boolean enabled);

  ArchiveConfigurationResponse getArchiveConfigurationsById(int id);

  ArchiveDataInfo getArchiveTableDataInformation(ArchiveDataInfoRequest request);



}

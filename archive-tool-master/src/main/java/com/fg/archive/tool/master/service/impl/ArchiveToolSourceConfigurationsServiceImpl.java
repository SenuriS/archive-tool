package com.fg.archive.tool.master.service.impl;

import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import com.fg.archive.tool.master.invoker.ArchiveToolSourceInvokerService;
import com.fg.archive.tool.master.service.ArchiveToolSourceConfigurationsService;
import com.fg.archive.tool.master.service.helper.ArchiveToolSourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveToolSourceConfigurationsServiceImpl implements ArchiveToolSourceConfigurationsService {

    @Autowired
    ArchiveToolSourceInvokerService archiveToolSourceInvokerService;

    @Autowired
    ArchiveToolSourceHelper sourceHelper;


    @Override
    public List<ArchiveConfiguration> getArchiveTableListConfigurations(boolean enabled) {
        return archiveToolSourceInvokerService.getArchiveTableListConfigurations(enabled);
    }

    @Override
    public ArchiveConfigurationResponse getArchiveConfigurationsById(int id) {
        return archiveToolSourceInvokerService.getArchiveConfigurationsById(id);
    }

    @Override
    public ArchiveDataInfo getArchiveTableDataInformation(ArchiveDataInfoRequest request) {
      String formattedStartDate = sourceHelper.generateStartDateToMidNight(request.getStartDate());
      String formattedEndDate = sourceHelper.generateEndDateToMidNight(request.getEndDate());
      request.setStartDate(formattedStartDate);
      request.setEndDate(formattedEndDate);
      return archiveToolSourceInvokerService.getArchiveTableDataInformation(request);
    }


}

package com.fg.archive.tool.master.service.impl;

import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.common.model.request.ArchiveDataDestinationRequest;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.request.TableCreationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.master.invoker.ArchiveToolDestinationInvokerService;
import com.fg.archive.tool.master.invoker.ArchiveToolSourceInvokerService;
import com.fg.archive.tool.master.service.ArchiveToolDestinationService;
import com.fg.archive.tool.master.service.helper.ArchiveToolSourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveToolDestinationServiceImpl implements ArchiveToolDestinationService {

    @Autowired
    ArchiveToolSourceInvokerService archiveToolSourceInvokerService;

    @Autowired
    ArchiveToolDestinationInvokerService archiveToolDestinationInvokerService;

    @Autowired
    ArchiveToolSourceHelper archiveToolSourceHelper;

    @Override
    public CommonResponse archiveDestinationData(ArchiveDataInfoRequest request) {

        String startDateToMidNight = archiveToolSourceHelper.generateStartDateToMidNight(request.getStartDate());
        String endDateToMidNight = archiveToolSourceHelper.generateEndDateToMidNight(request.getEndDate());

        request.setStartDate(startDateToMidNight);
        request.setEndDate(endDateToMidNight);

        List<SourceDBTableSchema> schemaList = archiveToolSourceInvokerService.getSourceTableSchema(request.getTableName());
        TableCreationRequest tableCreationRequest = new TableCreationRequest();
        tableCreationRequest.setSchemaList(schemaList);

        ArchiveDataDestinationRequest dataDestinationRequest = new ArchiveDataDestinationRequest();
        dataDestinationRequest.setArchiveDataInfoRequest(request);
        dataDestinationRequest.setTableCreationRequest(tableCreationRequest);

        return archiveToolDestinationInvokerService.archiveDestinationData(dataDestinationRequest);

    }
}

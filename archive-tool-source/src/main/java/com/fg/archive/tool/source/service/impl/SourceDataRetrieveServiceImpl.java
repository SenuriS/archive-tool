package com.fg.archive.tool.source.service.impl;

import com.fg.archive.tool.common.constant.APIResponseStatus;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.source.dao.ArchiveConfigurationDao;
import com.fg.archive.tool.source.dao.SourceDBDataArchiveDao;
import com.fg.archive.tool.source.dao.SourceDBTableSchemaDao;
import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.source.service.SourceDataRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceDataRetrieveServiceImpl implements SourceDataRetrieveService {

    @Autowired
    ArchiveConfigurationDao archiveConfigurationDao;

    @Autowired
    SourceDBDataArchiveDao sourceDBDataArchiveDao;

    @Autowired
    SourceDBTableSchemaDao sourceDBTableSchemaDao;

    @Override
    public List<ArchiveConfiguration> getArchiveTableListConfigurations(boolean enabled) {
        return archiveConfigurationDao.listArchiveConfigurationByStatus(enabled);
    }

    @Override
    public ArchiveConfigurationResponse getArchiveConfigurationsById(int id) {
        ArchiveConfigurationResponse archiveConfigurationResponse = new ArchiveConfigurationResponse();

        ArchiveConfiguration archiveConfiguration =  archiveConfigurationDao.getArchiveConfigurationId(id);

        String minValue = sourceDBDataArchiveDao.archiveTableMinValue(archiveConfiguration.getTableName(),
                archiveConfiguration.getArchiveColumn());
        String maxValue = sourceDBDataArchiveDao.archiveTableMaxValue(archiveConfiguration.getTableName(),
                archiveConfiguration.getArchiveColumn());
        Long rowCount = sourceDBDataArchiveDao.archiveTableRowCount(archiveConfiguration.getTableName());

        ArchiveDataInfo archiveDataInfo = new ArchiveDataInfo();
        archiveDataInfo.setMinDate(minValue);
        archiveDataInfo.setMaxDate(maxValue);
        archiveDataInfo.setRowCount(rowCount);

        archiveConfigurationResponse.setArchiveConfiguration(archiveConfiguration);
        archiveConfigurationResponse.setArchiveDataInfo(archiveDataInfo);

        return archiveConfigurationResponse;
    }

    @Override
    public ArchiveDataInfo getArchiveTableDataInformation(ArchiveDataInfoRequest request) {

        String minValue = sourceDBDataArchiveDao.archiveTableMinValue(request.getTableName(),
               request.getTableColumn(),request.getStartDate(),request.getEndDate());
        String maxValue = sourceDBDataArchiveDao.archiveTableMaxValue(request.getTableName(),
                request.getTableColumn(),request.getStartDate(),request.getEndDate());
        Long rowCount = sourceDBDataArchiveDao.archiveTableRowCount(request.getTableName(),
                request.getTableColumn(), request.getStartDate(),request.getEndDate());

        ArchiveDataInfo archiveDataInfo = new ArchiveDataInfo();
        archiveDataInfo.setMinDate(minValue);
        archiveDataInfo.setMaxDate(maxValue);
        archiveDataInfo.setRowCount(rowCount);

        return archiveDataInfo;
    }

    @Override
    public List<SourceDBTableSchema> getSourceTableSchema(String tableName) {
        return sourceDBTableSchemaDao.getArchiveTableSourceSchema(tableName);
    }

    @Override
    public CommonResponse deleteFromSourceTable(ArchiveDataInfoRequest request) {
     CommonResponse commonResponse = new CommonResponse();
     try{
       sourceDBDataArchiveDao.deleteFromSourceTable(request.getTableName(),request.getTableColumn(),
               request.getStartDate(),request.getEndDate());

     } catch (Exception e) {
         commonResponse.setResponseMessage(APIResponseStatus.FAILED.name());
         commonResponse.setResponseMessage(APIResponseStatus.FAILED.label);
     }
     return commonResponse;
    }
}

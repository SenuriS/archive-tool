package com.fg.archive.tool.destination.service.impl;

import com.fg.archive.tool.common.constant.APIResponseStatus;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.ArchiveDataLogHistory;
import com.fg.archive.tool.common.model.request.ArchiveDataDestinationRequest;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.request.TableCreationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.destination.dao.ArchiveDataLogHistoryDao;
import com.fg.archive.tool.destination.dao.DataArchiveDao;
import com.fg.archive.tool.destination.service.ArchiveDBTableManipulationService;
import com.fg.archive.tool.destination.service.ArchiveDataDestinationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiveDataDestinationManagerServiceImpl implements ArchiveDataDestinationManagerService {

    @Autowired
    ArchiveDBTableManipulationService manipulationService;

    @Autowired
    ArchiveDataLogHistoryDao logHistoryDao;

    @Autowired
    DataArchiveDao dataArchiveDao;

    @Override
    public CommonResponse archiveDestinationData(ArchiveDataDestinationRequest request) {
        CommonResponse commonResponse = new CommonResponse();
        ArchiveDataInfoRequest archiveDataInfo = request.getArchiveDataInfoRequest();
        TableCreationRequest tableCreationRequest  = request.getTableCreationRequest();

        String remoteTableName = request.getArchiveDataInfoRequest().getTableName();
        String archiveColumn = archiveDataInfo.getTableColumn();

        String federateTableName = remoteTableName + "_federate";
        String archiveTableName = remoteTableName + "_archive";

        String startDate = archiveDataInfo.getStartDate();
        String endDate = archiveDataInfo.getEndDate();

        try {
            commonResponse = manipulationService.createArchiveTables(remoteTableName,federateTableName, archiveTableName,tableCreationRequest);
            if(commonResponse.getResponseCode().equals(APIResponseStatus.SUCCESS.name())){

                String minValue = dataArchiveDao.archivedDataMinValue(federateTableName, archiveColumn,
                        startDate, endDate);
                String maxValue = dataArchiveDao.archivedDataMaxValue(federateTableName, archiveColumn,
                        startDate, endDate);
                Integer rowCount = dataArchiveDao.archiveDataRowCount(federateTableName,archiveColumn,
                        startDate, endDate);

                dataArchiveDao.archiveData(federateTableName,archiveColumn,archiveTableName,startDate,endDate);
                manipulationService.dropFederateTable(federateTableName);

                ArchiveDataLogHistory archiveDataLogHistory = new ArchiveDataLogHistory();
                archiveDataLogHistory.setArchiveSourceTableID(request.getArchiveDataInfoRequest().getTableId());
                archiveDataLogHistory.setArchiveDestTableName(archiveTableName);
                archiveDataLogHistory.setArchiveColumn(archiveColumn);
                archiveDataLogHistory.setStartValue(startDate);
                archiveDataLogHistory.setEndValue(endDate);
                archiveDataLogHistory.setArchivedRowCount(rowCount);
                archiveDataLogHistory.setArchiveMinValue(minValue);
                archiveDataLogHistory.setArchivedMaxValue(maxValue);

                logHistoryDao.createArchiveLogHistoryRecord(archiveDataLogHistory);
            }
            return commonResponse;

        } catch (Exception e) {
                commonResponse.setResponseCode(APIResponseStatus.FAILED.name());
                commonResponse.setResponseMessage(APIResponseStatus.FAILED.label);
                return commonResponse;
        }
    }
}

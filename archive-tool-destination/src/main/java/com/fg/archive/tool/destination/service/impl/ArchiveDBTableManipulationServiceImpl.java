package com.fg.archive.tool.destination.service.impl;

import com.fg.archive.tool.common.constant.APIResponseStatus;
import com.fg.archive.tool.common.model.request.TableCreationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.destination.dao.TableCreationDao;
import com.fg.archive.tool.destination.service.ArchiveDBTableManipulationService;
import com.fg.archive.tool.destination.service.helper.ArchiveDBTableManipulationServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiveDBTableManipulationServiceImpl implements ArchiveDBTableManipulationService {

    @Autowired
    TableCreationDao tableCreationDao;

    @Autowired
    ArchiveDBTableManipulationServiceHelper manipulationServiceHelper;

    @Override
    public CommonResponse createArchiveTables(String rmtTableName, String federateTable, String destTableName, TableCreationRequest request) {
        CommonResponse commonResponse = new CommonResponse();
        try {


            String federateTableSQL = manipulationServiceHelper.createTableScriptGeneratingHelper(rmtTableName, federateTable, "FEDERATED", request.getSchemaList());
            tableCreationDao.createTable(federateTableSQL);

            String archiveTableSQL = manipulationServiceHelper.createTableScriptGeneratingHelper(rmtTableName, destTableName, "InnoDB", request.getSchemaList());
            tableCreationDao.createTable(archiveTableSQL);

            commonResponse.setResponseCode(APIResponseStatus.SUCCESS.name());
            commonResponse.setResponseMessage(APIResponseStatus.SUCCESS.label);

        } catch (Exception e) {

            commonResponse.setResponseCode(APIResponseStatus.FAILED.name());
            commonResponse.setResponseMessage(APIResponseStatus.FAILED.label);

        }

        return commonResponse;
    }

    @Override
    public void dropFederateTable(String federateTable) {
        tableCreationDao.dropTable(federateTable);
    }
}

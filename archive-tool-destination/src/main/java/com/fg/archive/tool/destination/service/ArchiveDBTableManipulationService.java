package com.fg.archive.tool.destination.service;

import com.fg.archive.tool.common.model.request.TableCreationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;

public interface ArchiveDBTableManipulationService {

    CommonResponse createArchiveTables(String rmtTableName, String federateTable, String destTableName, TableCreationRequest request);

    void dropFederateTable(String federateTable);
}

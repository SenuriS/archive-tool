package com.fg.archive.tool.destination.service;

import com.fg.archive.tool.common.model.request.ArchiveDataDestinationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;

public interface ArchiveDataDestinationManagerService {

    CommonResponse archiveDestinationData(ArchiveDataDestinationRequest request);


}

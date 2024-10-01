package com.fg.archive.tool.master.service;

import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;

public interface ArchiveToolDestinationService {

    CommonResponse archiveDestinationData(ArchiveDataInfoRequest request);
}

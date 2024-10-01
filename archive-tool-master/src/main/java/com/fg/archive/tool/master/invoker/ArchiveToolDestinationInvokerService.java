package com.fg.archive.tool.master.invoker;

import com.fg.archive.tool.common.model.request.ArchiveDataDestinationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;

public interface ArchiveToolDestinationInvokerService {

    CommonResponse archiveDestinationData(ArchiveDataDestinationRequest request);
}

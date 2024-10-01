package com.fg.archive.tool.common.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchiveDataDestinationRequest {

    private ArchiveDataInfoRequest archiveDataInfoRequest;
    private TableCreationRequest tableCreationRequest;
}

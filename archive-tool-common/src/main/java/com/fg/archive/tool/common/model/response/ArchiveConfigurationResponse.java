package com.fg.archive.tool.common.model.response;

import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

@Getter
@Setter
public class ArchiveConfigurationResponse{

    private ArchiveConfiguration archiveConfiguration;
    private ArchiveDataInfo archiveDataInfo;
}

package com.fg.archive.tool.common.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchiveConfigurationRequest {

    private int archiveTableId;
    private String tableName;
    private String tableDisplayName;
    private String archiveColumn;
    private String archiveColumnType;
    private String archiveColumnDisplayName;
    private boolean archiveEnabled;
}

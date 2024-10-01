package com.fg.archive.tool.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchiveDataLogHistory {

    private int logID;
    private int archiveSourceTableID;
    private String archiveDestTableName;
    private String archiveColumn;
    private String startValue;
    private String endValue;
    private int archivedRowCount;
    private String archiveMinValue;
    private String archivedMaxValue;

}

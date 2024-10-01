package com.fg.archive.tool.common.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class ArchiveDataInfo {

    private String minDate;
    private String maxDate;
    private Long rowCount;

}

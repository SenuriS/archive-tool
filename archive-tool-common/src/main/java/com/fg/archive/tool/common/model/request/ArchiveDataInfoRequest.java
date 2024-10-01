package com.fg.archive.tool.common.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchiveDataInfoRequest {

 private int tableId;
 private String tableName;
 private String tableColumn;
 private String startDate;
 private String endDate;

}

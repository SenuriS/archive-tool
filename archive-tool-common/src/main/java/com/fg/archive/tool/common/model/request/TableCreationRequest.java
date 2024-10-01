package com.fg.archive.tool.common.model.request;

import com.fg.archive.tool.common.model.SourceDBTableSchema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableCreationRequest {
    private List<SourceDBTableSchema> schemaList;
}

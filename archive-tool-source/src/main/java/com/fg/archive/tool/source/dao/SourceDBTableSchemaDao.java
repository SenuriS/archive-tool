package com.fg.archive.tool.source.dao;

import com.fg.archive.tool.common.model.SourceDBTableSchema;

import java.util.List;

public interface SourceDBTableSchemaDao {

    List<SourceDBTableSchema> getArchiveTableSourceSchema(String tableName);


}

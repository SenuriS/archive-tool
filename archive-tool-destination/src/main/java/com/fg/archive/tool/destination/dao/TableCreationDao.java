package com.fg.archive.tool.destination.dao;

public interface TableCreationDao {

    void createTable(String createScript);

    void dropTable(String tableName);
}

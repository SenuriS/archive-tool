package com.fg.archive.tool.source.dao;

public interface SourceDBDataArchiveDao {

    String archiveTableMinValue(String archiveTable, String archiveColumn);

    String archiveTableMinValue(String archiveTable, String archiveColumn, String startDate, String endDate);

    String archiveTableMaxValue(String archiveTable, String archiveColumn);

    String archiveTableMaxValue(String archiveTable, String archiveColumn, String startDate, String endDate);

    Long archiveTableRowCount(String archiveTable);

    Long archiveTableRowCount(String archiveTable,String archiveColumn, String startDate, String endDate);

    void deleteFromSourceTable(String archiveTable,String archiveColumn, String startDate, String endDate);
}

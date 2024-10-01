package com.fg.archive.tool.destination.dao;

public interface DataArchiveDao {

    String archivedDataMinValue(String srcTable, String srcColumn, String startDate, String endDate);

    String archivedDataMaxValue(String srcTable, String srcColumn, String startDate, String endDate);

    Integer archiveDataRowCount(String srcTable,String srcColumn, String startDate, String endDate);

    void archiveData(String srcTable,String srcColumn, String destTable, String startDate, String endDate );
}

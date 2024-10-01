package com.fg.archive.tool.common.path;

public interface RestAPIPath {

    String ARCHIVE_TOOL_SOURCE = "/archive-tool-source";

    String ARCHIVE_TOOL_DESTINATION = "/archive-tool-destination";

    String ARCHIVE_TOOL_SOURCE_DATA_CONFIG = "/archive-data-configurations";

    String ARCHIVE_TOOL_SOURCE_GET_TABLE_LIST = "/get-enabled/{enabled}";

    String ARCHIVE_TOOL_SOURCE_GET_TABLE_BY_ID= "/get-by-id/{id}";

    String ARCHIVE_TOOL_MASTER_GET_TABLE_LIST = "/get-enabled";

    String ARCHIVE_TOOL_SOURCE_ARCHIVE_DATA_INFO = "/get-table/archive-info";

    String ARCHIVE_TOOL_SOURCE_SCHEMA = "/get-table/{tableName}";

    String ARCHIVE_TOOL_DESTINATION_MANAGER = "/archive-data-manager";

    String ARCHIVE_TOOL_ARCHIVE = "/archive";

    String ARCHIVE_SOURCE_TABLE_RECORD_DELETE = "/get-table/delete-records";

    String ARCHIVE_TOOL_HISTORY = "/archive-tool-history";

    String ARCHIVE_TOOL_HISTORY_LAST_RECORD="/get-last-record";

    String ARCHIVE_TOOL_HISTORY_LAST_RECORD_BY_TABLE="/get-last-record/{tableName}";

    String ARCHIVE_TOOL_HISTORY_LAST_RECORD_LIST_BY_TABLE="/get-last-record-list/{tableName}";

}

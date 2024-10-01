package com.fg.archive.tool.common.constant;

public enum APIResponseStatus {

    SUCCESS("Process Completed Successfully..!"),
    FAILED("Process Failed..!");

    public final String label;

    private APIResponseStatus(String label) {
        this.label = label;
    }
}

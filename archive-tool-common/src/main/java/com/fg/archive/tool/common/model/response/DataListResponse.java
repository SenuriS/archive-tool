package com.fg.archive.tool.common.model.response;

import com.fg.archive.tool.common.constant.APIResponseStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataListResponse<T> {


    private List<T> dataListResponse;

    public DataListResponse() {
    }

    public DataListResponse(List<T> dataListResponse) {
        this.dataListResponse = dataListResponse;
    }
}

package com.fg.archive.tool.master.controller;


import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import com.fg.archive.tool.common.model.response.DataListResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.master.service.ArchiveToolSourceConfigurationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE)
public class ArchiveToolSourceController {

    @Autowired
    ArchiveToolSourceConfigurationsService ArchiveToolSourceConfigurationsService;

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_MASTER_GET_TABLE_LIST)
    public DataListResponse<ArchiveConfiguration> getArchiveTableListConfigurations(){
        return new DataListResponse<>(ArchiveToolSourceConfigurationsService.getArchiveTableListConfigurations(true));

    }

    @GetMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_GET_TABLE_BY_ID)
    public ArchiveConfigurationResponse getArchiveConfigurationsById(@PathVariable int id){
        return ArchiveToolSourceConfigurationsService.getArchiveConfigurationsById(id);

    }

    @PostMapping(RestAPIPath.ARCHIVE_TOOL_SOURCE_ARCHIVE_DATA_INFO)
    @ResponseBody
    public ArchiveDataInfo getArchiveDataInfo(@RequestBody ArchiveDataInfoRequest request){
        return ArchiveToolSourceConfigurationsService.getArchiveTableDataInformation(request);

    }

}

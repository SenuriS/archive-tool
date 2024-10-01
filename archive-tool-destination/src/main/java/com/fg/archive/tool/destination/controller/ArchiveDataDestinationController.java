package com.fg.archive.tool.destination.controller;

import com.fg.archive.tool.common.model.request.ArchiveDataDestinationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.destination.service.ArchiveDataDestinationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestAPIPath.ARCHIVE_TOOL_DESTINATION_MANAGER)
public class ArchiveDataDestinationController {

    @Autowired
    ArchiveDataDestinationManagerService archiveDataDestinationManagerService;


    @PostMapping(RestAPIPath.ARCHIVE_TOOL_ARCHIVE)
    @ResponseBody
    CommonResponse archiveDataDestination(@RequestBody ArchiveDataDestinationRequest request)
    {
        return archiveDataDestinationManagerService.archiveDestinationData(request);
    }

}

package com.fg.archive.tool.master.controller;


import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.master.service.ArchiveToolDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestAPIPath.ARCHIVE_TOOL_DESTINATION)
public class ArchiveToolDestinationController {

    @Autowired
    ArchiveToolDestinationService archiveToolDestinationService;

    @PostMapping(RestAPIPath.ARCHIVE_TOOL_ARCHIVE)
    @ResponseBody
    CommonResponse archiveDataDestination(@RequestBody ArchiveDataInfoRequest request)
    {
        return archiveToolDestinationService.archiveDestinationData(request);
    }

}

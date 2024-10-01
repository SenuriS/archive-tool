package com.fg.archive.tool.master.invoker.impl;

import com.fg.archive.tool.common.model.request.ArchiveDataDestinationRequest;
import com.fg.archive.tool.common.model.response.CommonResponse;
import com.fg.archive.tool.common.path.RestAPIPath;
import com.fg.archive.tool.master.config.RestTemplateClass;
import com.fg.archive.tool.master.invoker.ArchiveToolDestinationInvokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ArchiveToolDestinationInvokerServiceImpl implements ArchiveToolDestinationInvokerService {

    @Autowired
    RestTemplateClass restTemplate;

    @Value("${arch.tool.dest.service}")
    private String SERVICE_IP;

    String basePath = RestAPIPath.ARCHIVE_TOOL_DESTINATION_MANAGER;

    String generateURLArchiveDestination(String sourceEndPoint){
        return this.SERVICE_IP+basePath+sourceEndPoint;
    }

    @Override
    public CommonResponse archiveDestinationData(ArchiveDataDestinationRequest request) {
        String url = generateURLArchiveDestination(RestAPIPath.ARCHIVE_TOOL_ARCHIVE);
        CommonResponse commonResponse = restTemplate.postForObject(url, request, CommonResponse.class);
        return commonResponse;
    }
}

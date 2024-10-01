package com.fg.archive.tool.master.invoker;

import com.fg.archive.tool.common.model.ArchiveConfiguration;
import com.fg.archive.tool.common.model.ArchiveDataInfo;
import com.fg.archive.tool.common.model.SourceDBTableSchema;
import com.fg.archive.tool.common.model.request.ArchiveDataInfoRequest;
import com.fg.archive.tool.common.model.response.ArchiveConfigurationResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ArchiveToolSourceInvokerService {

    List<ArchiveConfiguration> getArchiveTableListConfigurations(boolean enabled);

    ArchiveConfigurationResponse getArchiveConfigurationsById(int id);

    ArchiveDataInfo getArchiveTableDataInformation(ArchiveDataInfoRequest request);

    List<SourceDBTableSchema> getSourceTableSchema(String tableName);


}

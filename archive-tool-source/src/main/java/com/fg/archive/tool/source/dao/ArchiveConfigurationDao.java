package com.fg.archive.tool.source.dao;

import com.fg.archive.tool.common.model.ArchiveConfiguration;

import java.util.List;

public interface ArchiveConfigurationDao {

    List<ArchiveConfiguration> listArchiveConfigurationByStatus(boolean enabled);

    ArchiveConfiguration getArchiveConfigurationId(int id);
}

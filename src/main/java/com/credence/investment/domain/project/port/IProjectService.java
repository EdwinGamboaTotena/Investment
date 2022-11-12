package com.credence.investment.domain.project.port;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.project.Project;
import com.credence.investment.domain.project.dto.CreateProjectDto;
import com.credence.investment.domain.project.dto.UpdateProjectDto;

public interface IProjectService {

    PaginatorDto<Project> get(int page, int size);

    Project getById(String id);

    Project create(CreateProjectDto dto, String user);

    void update(String id, UpdateProjectDto dto);

}

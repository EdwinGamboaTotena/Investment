package com.credence.investment.domain.project.port;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.project.Project;
import com.credence.investment.domain.project.dto.CreateProjectDto;
import com.credence.investment.domain.project.dto.UpdateProjectDto;

public interface IProjectService {

    PaginatorDto<Project> getProjects(int page, int size);

    Project getProjectById(String id);

    Project createProject(CreateProjectDto dto);

    void updateProject(String id, UpdateProjectDto dto);

}

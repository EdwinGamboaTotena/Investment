package com.credence.investment.domain.project.port;

import com.credence.investment.domain.project.Project;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IProjectRepository {

    Page<Project> getProjects(int page, int size);

    Project getProjectById(UUID id);

    Project createProject(Project model);

    void updateProject(Project model);
}

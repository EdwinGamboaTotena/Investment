package com.credence.investment.infraestructure.project;

import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.project.Project;
import com.credence.investment.domain.project.port.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class ProjectRepository implements IProjectRepository {

    public static final String PROJECT_NOT_FOUND = "No se a encontrado el proyecto";

    @Autowired
    private ProjectJpa jpa;

    @Override
    public Page<Project> getProjects(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<ProjectEntity> projects = jpa.findAll(paging);
        return ProjectFactory.entityToModel(projects);
    }

    @Override
    public Project getProjectById(UUID id) {
        ProjectEntity entity = jpa.findById(id)
                .orElseThrow(() -> new BadRequest(PROJECT_NOT_FOUND));
        return ProjectFactory.entityToModel(entity);
    }

    @Override
    public Project createProject(Project model) {
        ProjectEntity entity = ProjectFactory.modelToEntity(model);
        entity = jpa.save(entity);
        return ProjectFactory.entityToModel(entity);
    }

    @Override
    public void updateProject(Project model) {
        ProjectEntity entity = ProjectFactory.modelToEntity(model);
        jpa.save(entity);
    }
}

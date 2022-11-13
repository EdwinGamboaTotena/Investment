package com.credence.investment.infraestructure.project;

import com.credence.investment.domain.project.Project;
import com.credence.investment.domain.project.port.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProjectRepository implements IProjectRepository {

    @Autowired
    private ProjectJpa jpa;

    @Override
    public Page<Project> get(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<ProjectEntity> entities = jpa.findAll(paging);
        return ProjectMapper.entityToModel(entities);
    }

    @Override
    public Project getById(UUID id) {
        ProjectEntity entity = jpa.findById(id).orElse(null);
        return ProjectMapper.entityToModel(entity);
    }

    @Override
    public Project save(Project model) {
        ProjectEntity entity = ProjectMapper.modelToEntity(model);
        entity = jpa.save(entity);
        return ProjectMapper.entityToModel(entity);
    }

}

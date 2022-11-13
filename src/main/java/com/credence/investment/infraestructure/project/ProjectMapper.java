package com.credence.investment.infraestructure.project;

import com.credence.investment.domain.project.Project;
import com.credence.investment.infraestructure.user.UserMapper;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class ProjectMapper {

    private ProjectMapper() {
    }

    public static final Page<Project> entityToModel(Page<ProjectEntity> page) {
        return page.map(p -> entityToModel(p));
    }

    public static final Project
    entityToModel(ProjectEntity entity) {
        if (entity == null) return null;
        Project model = Project.builder()
                .id(entity.getId().toString())
                .name(entity.getName())
                .description(entity.getDescription())
                .url(entity.getUrl())
                .amountUsed(entity.getAmountUsed())
                .expectedPercentage(entity.getExpectedPercentage())
                .currencyUsed(entity.getCurrencyUsed())
                .status(entity.getStatus())
                .createBy(UserMapper.entityToModel(entity.getCreateBy()))
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();

        return model;
    }

    public static final ProjectEntity modelToEntity(Project model) {
        if (model == null) return null;
        ProjectEntity entity = ProjectEntity.builder()
                .name(model.getName())
                .description(model.getDescription())
                .url(model.getUrl())
                .amountUsed(model.getAmountUsed())
                .expectedPercentage(model.getExpectedPercentage())
                .currencyUsed(model.getCurrencyUsed())
                .status(model.getStatus())
                .createBy(UserMapper.modelToEntity(model.getCreateBy()))
                .createAt(model.getCreateAt())
                .updateAt(model.getUpdateAt())
                .build();

        if (model.getId() != null && !model.getId().isBlank()) {
            entity.setId(UUID.fromString(model.getId()));
        }

        return entity;
    }
}

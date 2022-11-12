package com.credence.investment.domain.project;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.project.dto.CreateProjectDto;
import com.credence.investment.domain.project.dto.UpdateProjectDto;
import com.credence.investment.domain.project.port.IProjectRepository;
import com.credence.investment.domain.project.port.IProjectService;
import com.credence.investment.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class ProjectService implements IProjectService {

    public static final String PROJECT_NOT_FOUND = "No se encuentra el projecto a actualizar";
    @Autowired
    private IProjectRepository repository;

    @Override
    public PaginatorDto<Project> get(int page, int size) {
        Page<Project> projects = repository.get(page, size);
        PaginatorDto<Project> paginator = new PaginatorDto<>();

        paginator.setTotalPages(projects.getTotalPages());
        paginator.setTotalElements(projects.getTotalElements());
        paginator.setContent(projects.getContent());
        return paginator;
    }

    @Override
    public Project getById(String id) {
        return repository.getById(UUID.fromString(id));
    }

    @Override
    public Project create(CreateProjectDto dto, String user) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setUrl(dto.getUrl());
        project.setAmountUsed(dto.getAmountUsed());
        project.setExpectedPercentage(dto.getExpectedPercentage());
        project.setCurrencyUsed(dto.getCurrencyUsed());
        project.setStatus(ProjectStatusEnum.REVIEW);
        project.setCreateBy(User.builder().id(user).build());
        project.setCreateDate(LocalDateTime.now());
        project.setUpdateDate(LocalDateTime.now());

        project.isValid();
        return repository.create(project);
    }

    @Override
    public void update(String id, UpdateProjectDto dto) {
        Project project = repository.getById(UUID.fromString(id));
        if (project == null) {
            throw new BadRequest(PROJECT_NOT_FOUND);
        }
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setUrl(dto.getUrl());
        project.setAmountUsed(dto.getAmountUsed());
        project.setExpectedPercentage(dto.getExpectedPercentage());
        project.setCurrencyUsed(dto.getCurrencyUsed());
        project.setStatus(dto.getStatus());
        project.setUpdateDate(LocalDateTime.now());

        project.isValid();
        repository.update(project);
    }
}

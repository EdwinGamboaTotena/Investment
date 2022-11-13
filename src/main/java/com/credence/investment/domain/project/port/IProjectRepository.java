package com.credence.investment.domain.project.port;

import com.credence.investment.domain.project.Project;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IProjectRepository {

    Page<Project> get(int page, int size);

    Project getById(UUID id);

    Project save(Project model);
}

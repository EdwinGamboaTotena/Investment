package com.credence.investment.application.project;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.project.Project;
import com.credence.investment.domain.project.dto.CreateProjectDto;
import com.credence.investment.domain.project.dto.UpdateProjectDto;
import com.credence.investment.domain.project.port.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    private IProjectService service;

    @GetMapping
    PaginatorDto<Project> getProjects(@RequestParam int page, @RequestParam int size) {
        return service.get(page, size);
    }

    @GetMapping("/{id}")
    Project getProjectById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    Project createProject(@PathVariable CreateProjectDto dto, @RequestHeader String user) {
        return service.create(dto, user);
    }

    @PutMapping("/{id}")
    void updateProject(@PathVariable String id, @RequestBody UpdateProjectDto dto) {
        service.update(id, dto);
    }
}

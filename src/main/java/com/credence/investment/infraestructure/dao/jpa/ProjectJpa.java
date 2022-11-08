package com.credence.investment.infraestructure.dao.jpa;

import com.credence.investment.infraestructure.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ProjectJpa extends JpaRepository<ProjectEntity, UUID> {
}

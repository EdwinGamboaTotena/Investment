package com.credence.investment.infraestructure.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ProjectJpa extends JpaRepository<ProjectEntity, UUID> {
}

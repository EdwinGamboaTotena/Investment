package com.credence.investment.infraestructure.dao.jpa;

import com.credence.investment.infraestructure.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpa extends JpaRepository<Long, RolEntity> {
}

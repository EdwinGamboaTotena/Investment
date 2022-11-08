package com.credence.investment.infraestructure.dao.jpa;

import com.credence.investment.infraestructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserJpa extends JpaRepository<UserEntity, UUID> {
}

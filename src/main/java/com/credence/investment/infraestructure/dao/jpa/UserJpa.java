package com.credence.investment.infraestructure.dao.jpa;

import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.infraestructure.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface UserJpa extends JpaRepository<UserEntity, UUID> {

    @Query(value = "UPDATE UserEntity user SET user.password = :pass WHERE user.id = :id")
    public void updatePassword(UUID id, String pass);

    Page<UserEntity> findAll(Pageable pageable);

    Page<UserEntity> findByStatus(StatusEnum status, Pageable pageable);
}

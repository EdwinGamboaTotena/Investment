package com.credence.investment.infraestructure.user;

import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface UserJpa extends JpaRepository<UserEntity, UUID> {

    @Query(value = "UPDATE UserEntity user SET user.password = :pass WHERE user.id = :id")
    void updatePassword(UUID id, String pass);

    Page<UserEntity> findByStatus(StatusEnum status, Pageable pageable);

    User findByEmail(String email);
}

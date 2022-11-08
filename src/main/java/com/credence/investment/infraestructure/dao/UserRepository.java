package com.credence.investment.infraestructure.dao;

import com.credence.investment.domain.dao.IUserRepository;
import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.domain.model.User;
import com.credence.investment.infraestructure.dao.jpa.UserJpa;
import com.credence.investment.infraestructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private UserJpa jpa;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = UserEntity.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .rol(user.getRol())
                .status(StatusEnum.ACTIVE)
                .build();

        return entityToModel(jpa.save(userEntity));
    }

    private User entityToModel(UserEntity userEntity) {
        User user = User.builder()
                .id(userEntity.getId().toString())
                .name(userEntity.getName())
                .lastname(userEntity.getLastname())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .rol(userEntity.getRol())
                .status(userEntity.getStatus())
                .build();

        return user;
    }

    private UserEntity modelToEntity(User user) {
        UserEntity userEntity = UserEntity.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .rol(user.getRol())
                .status(StatusEnum.ACTIVE)
                .build();

        if(!user.getId().isBlank()) {
            userEntity.setId(UUID.fromString(user.getId()));
        }

        return userEntity;
    }
}

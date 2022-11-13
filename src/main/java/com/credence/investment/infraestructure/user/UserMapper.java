package com.credence.investment.infraestructure.user;

import com.credence.investment.domain.user.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class UserMapper {

    private UserMapper() {
    }

    public static final Page<User> entityToModel(Page<UserEntity> page) {
        return page.map(p -> entityToModel(p));
    }

    public static final User entityToModel(UserEntity entity) {
        if (entity == null) return null;
        User model = User.builder()
                .id(entity.getId().toString())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .password(entity.getPassword())
                .rol(entity.getRol())
                .isActive(entity.isActive())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();

        return model;
    }

    public static final UserEntity modelToEntity(User model) {
        if (model == null) return null;
        UserEntity entity = UserEntity.builder()
                .name(model.getName())
                .lastname(model.getLastname())
                .email(model.getEmail())
                .phone(model.getPhone())
                .password(model.getPassword())
                .rol(model.getRol())
                .isActive(model.isActive())
                .createAt(model.getCreateAt())
                .updateAt(model.getUpdateAt())
                .build();

        if (model.getId() != null && !model.getId().isBlank()) {
            entity.setId(UUID.fromString(model.getId()));
        }

        return entity;
    }
}

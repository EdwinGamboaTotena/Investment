package com.credence.investment.infraestructure.factory;

import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.domain.model.User;
import com.credence.investment.infraestructure.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserFactory {

    private UserFactory() {
    }

    public static final User entityToModel(UserEntity userEntity) {
        User user = User.builder()
                .id(userEntity.getId().toString())
                .name(userEntity.getName())
                .lastname(userEntity.getLastname())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .password(userEntity.getPassword())
                .rol(userEntity.getRol())
                .status(userEntity.getStatus())
                .createDate(userEntity.getCreateDate())
                .updateDate(userEntity.getUpdateDate())
                .build();

        return user;
    }

    public static final Page<User> entityToModel(Page<UserEntity> page) {
        return page.map(p -> entityToModel(p));
    }

    public static final UserEntity modelToEntity(User user) {
        UserEntity userEntity = UserEntity.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .rol(user.getRol())
                .status(user.getStatus())
                .createDate(user.getCreateDate())
                .updateDate(user.getUpdateDate())
                .build();

        if (user.getId() != null && !user.getId().isBlank()) {
            userEntity.setId(UUID.fromString(user.getId()));
        }

        return userEntity;
    }
}

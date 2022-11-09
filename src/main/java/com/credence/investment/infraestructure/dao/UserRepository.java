package com.credence.investment.infraestructure.dao;

import com.credence.investment.domain.dao.IUserRepository;
import com.credence.investment.domain.exception.BadRequest;
import com.credence.investment.domain.model.User;
import com.credence.investment.infraestructure.dao.jpa.UserJpa;
import com.credence.investment.infraestructure.entity.UserEntity;
import com.credence.investment.infraestructure.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository implements IUserRepository {

    public static final String USER_NOT_FOUND = "No se a encontrado el usuario";

    @Autowired
    private UserJpa jpa;

    @Override
    public Page<User> getUsersList(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<UserEntity> users = jpa.findAll(paging);
        return UserFactory.entityToModel(users);
    }

    @Override
    public User getUserById(UUID id) {
        UserEntity user = jpa.findById(id)
                .orElseThrow(() -> new BadRequest(USER_NOT_FOUND));
        return UserFactory.entityToModel(user);
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = UserFactory.modelToEntity(user);
        userEntity = jpa.save(userEntity);
        return UserFactory.entityToModel(userEntity);
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = UserFactory.modelToEntity(user);
        userEntity = jpa.save(userEntity);
        return UserFactory.entityToModel(userEntity);
    }

    @Override
    public void updatePassword(UUID id, String pass) {
        jpa.updatePassword(id, pass);
    }


}

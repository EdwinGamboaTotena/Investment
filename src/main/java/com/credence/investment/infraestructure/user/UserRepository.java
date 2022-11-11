package com.credence.investment.infraestructure.user;

import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.user.User;
import com.credence.investment.domain.user.ports.IUserRepository;
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
    public User getByEmail(String email) {
        return jpa.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = UserFactory.modelToEntity(user);
        userEntity = jpa.save(userEntity);
        return UserFactory.entityToModel(userEntity);
    }

    @Override
    public void updateUser(User user) {
        UserEntity userEntity = UserFactory.modelToEntity(user);
        jpa.save(userEntity);
    }

    @Override
    public void updatePassword(UUID id, String pass) {
        jpa.updatePassword(id, pass);
    }


}

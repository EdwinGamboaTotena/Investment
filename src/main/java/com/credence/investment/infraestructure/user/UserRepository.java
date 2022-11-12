package com.credence.investment.infraestructure.user;

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

    @Autowired
    private UserJpa jpa;

    @Override
    public Page<User> get(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<UserEntity> entities = jpa.findAll(paging);
        return UserMapper.entityToModel(entities);
    }

    @Override
    public User getById(UUID id) {
        UserEntity entity = jpa.findById(id).orElse(null);
        return UserMapper.entityToModel(entity);
    }

    @Override
    public User getByEmail(String email) {
        return jpa.findByEmail(email);
    }

    @Override
    public User create(User model) {
        UserEntity entity = UserMapper.modelToEntity(model);
        entity = jpa.save(entity);
        return UserMapper.entityToModel(entity);
    }

    @Override
    public void update(User user) {
        UserEntity entity = UserMapper.modelToEntity(user);
        jpa.save(entity);
    }

    @Override
    public void updatePassword(UUID id, String pass) {
        jpa.updatePassword(id, pass);
    }


}

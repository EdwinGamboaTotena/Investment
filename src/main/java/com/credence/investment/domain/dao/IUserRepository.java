package com.credence.investment.domain.dao;

import com.credence.investment.application.dto.PaginatorDto;
import com.credence.investment.domain.model.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IUserRepository {

    public Page<User> getUsersList(int page, int size);

    public User getUserById(UUID id);

    public User createUser(User user);

    public User updateUser(User user);

    public void updatePassword(UUID id, String pass);
}

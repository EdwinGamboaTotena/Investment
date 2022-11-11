package com.credence.investment.domain.user.ports;

import com.credence.investment.domain.user.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IUserRepository {

    Page<User> getUsers(int page, int size);

    User getUserById(UUID id);

    User getByEmail(String email);

    User createUser(User user);

    void updateUser(User user);

    void updatePassword(UUID id, String pass);
}

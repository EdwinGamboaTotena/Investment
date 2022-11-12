package com.credence.investment.domain.user.ports;

import com.credence.investment.domain.user.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IUserRepository {

    Page<User> get(int page, int size);

    User getById(UUID id);

    User getByEmail(String email);

    User create(User user);

    void update(User user);

    void updatePassword(UUID id, String pass);
}

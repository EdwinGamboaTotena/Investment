package com.credence.investment.domain.service.impl;

import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UserDto;
import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public User createUser(UserDto userDto) {
        return null;
    }

    @Override
    public void changePassword(PasswordDto passwordDto) {

    }
}

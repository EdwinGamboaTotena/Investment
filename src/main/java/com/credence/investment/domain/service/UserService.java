package com.credence.investment.domain.service;

import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UserDto;
import com.credence.investment.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public List<User> getUsersList();

    public User getUserById(UUID id);

    public User createUser(UserDto userDto);

    public void changePassword(PasswordDto passwordDto);
}

package com.credence.investment.domain.service;

import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UserDto;
import com.credence.investment.domain.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getUsersList();

    public User getUserById(String id);

    public User createUser(UserDto userDto);

    public void updatePassword(PasswordDto passwordDto);
}

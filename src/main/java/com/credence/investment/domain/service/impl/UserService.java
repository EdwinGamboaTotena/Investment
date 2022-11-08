package com.credence.investment.domain.service.impl;

import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UserDto;
import com.credence.investment.domain.dao.IUserRepository;
import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .rol(userDto.getRol())
                .build();

        return userRepository.createUser(user);
    }

    @Override
    public void updatePassword(PasswordDto passwordDto) {

    }
}

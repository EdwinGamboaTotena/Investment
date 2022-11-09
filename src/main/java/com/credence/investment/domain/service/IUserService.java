package com.credence.investment.domain.service;

import com.credence.investment.application.dto.CreateUserDto;
import com.credence.investment.application.dto.PaginatorDto;
import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UpdateUserDto;
import com.credence.investment.domain.model.User;
import org.springframework.data.domain.Page;

public interface IUserService {

    public PaginatorDto<User> getUsersList(int page, int size);

    public User getUserById(String id);

    public User createUser(CreateUserDto createUserDto);

    public User updateUser(String id, UpdateUserDto createUserDto);

    public void updatePassword(PasswordDto passwordDto);
}

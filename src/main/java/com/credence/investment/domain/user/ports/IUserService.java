package com.credence.investment.domain.user.ports;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.user.User;
import com.credence.investment.domain.user.dto.CreateUserDto;
import com.credence.investment.domain.user.dto.PasswordDto;
import com.credence.investment.domain.user.dto.UpdateUserDto;

public interface IUserService {

    PaginatorDto<User> getUsers(int page, int size);

    User getUserById(String id);

    User createUser(CreateUserDto createUserDto);

    void updateUser(String id, UpdateUserDto updateUserDto);

    void updatePassword(PasswordDto passwordDto);
}

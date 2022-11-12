package com.credence.investment.domain.user.ports;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.user.User;
import com.credence.investment.domain.user.dto.CreateUserDto;
import com.credence.investment.domain.user.dto.PasswordDto;
import com.credence.investment.domain.user.dto.UpdateUserDto;

public interface IUserService {

    PaginatorDto<User> get(int page, int size);

    User getById(String id);

    User create(CreateUserDto createUserDto);

    void update(String id, UpdateUserDto updateUserDto);

    void updatePassword(PasswordDto passwordDto);
}

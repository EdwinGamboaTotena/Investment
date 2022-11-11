package com.credence.investment.domain.user;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.user.dto.CreateUserDto;
import com.credence.investment.domain.user.dto.PasswordDto;
import com.credence.investment.domain.user.dto.UpdateUserDto;
import com.credence.investment.domain.user.ports.IUserRepository;
import com.credence.investment.domain.user.ports.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class UserService implements IUserService {


    public static final String DUPLICATE_EMAIL = "El email ingresado ya existe";
    public static final String USER_NOT_FOUND = "No se encuentra el usuario a actualizar";

    @Autowired
    private IUserRepository userRepository;

    @Override
    public PaginatorDto<User> getUsersList(int page, int size) {
        Page<User> users = userRepository.getUsersList(page, size);
        PaginatorDto<User> paginator = new PaginatorDto<>();

        paginator.setTotalPages(users.getTotalPages());
        paginator.setTotalElements(users.getTotalElements());
        paginator.setContent(users.getContent());
        return paginator;
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserById(UUID.fromString(id));
    }

    @Override
    public User createUser(CreateUserDto createUserDto) {
        User user = userRepository.getByEmail(createUserDto.getEmail());
        if (user != null) {
            throw new BadRequest(DUPLICATE_EMAIL);
        }
        user = new User();
        user.setName(createUserDto.getName());
        user.setLastname(createUserDto.getLastname());
        user.setEmail(createUserDto.getEmail());
        user.setPhone(createUserDto.getPhone());
        user.setPassword(createUserDto.getPassword());
        user.setRol(createUserDto.getRol());
        user.setStatus(StatusEnum.ACTIVE);
        user.setCreateDate(LocalDateTime.now());
        user.setUpdateDate(LocalDateTime.now());

        user.isValid();

        return userRepository.createUser(user);
    }

    @Override
    public void updateUser(String id, UpdateUserDto updateUserDto) {
        User user = userRepository.getUserById(UUID.fromString(id));
        if (user == null) {
            throw new BadRequest(USER_NOT_FOUND);
        }
        user.setName(updateUserDto.getName());
        user.setLastname(updateUserDto.getLastname());
        user.setPhone(updateUserDto.getPhone());
        user.setRol(updateUserDto.getRol());
        user.setStatus(updateUserDto.getStatus());
        user.setUpdateDate(LocalDateTime.now());

        user.isValid();
        userRepository.updateUser(user);
    }


    @Override
    public void updatePassword(PasswordDto passwordDto) {
        userRepository.updatePassword(UUID.fromString(passwordDto.getId()), passwordDto.getNewPassword());
    }
}

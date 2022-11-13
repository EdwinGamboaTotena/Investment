package com.credence.investment.domain.user;

import com.credence.investment.domain.common.dto.PaginatorDto;
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
    private IUserRepository repository;

    @Override
    public PaginatorDto<User> get(int page, int size) {
        Page<User> users = repository.get(page, size);
        PaginatorDto<User> paginator = new PaginatorDto<>();

        paginator.setTotalPages(users.getTotalPages());
        paginator.setTotalElements(users.getTotalElements());
        paginator.setContent(users.getContent());
        return paginator;
    }

    @Override
    public User getById(String id) {
        return repository.getById(UUID.fromString(id));
    }

    @Override
    public User create(CreateUserDto createUserDto) {
        User user = repository.getByEmail(createUserDto.getEmail());
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
        user.setActive(true);
        user.setCreateAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());

        user.isValid();

        return repository.create(user);
    }

    @Override
    public void update(String id, UpdateUserDto updateUserDto) {
        User user = repository.getById(UUID.fromString(id));
        if (user == null) {
            throw new BadRequest(USER_NOT_FOUND);
        }
        user.setName(updateUserDto.getName());
        user.setLastname(updateUserDto.getLastname());
        user.setPhone(updateUserDto.getPhone());
        user.setActive(updateUserDto.isActive());
        user.setRol(updateUserDto.getRol());
        user.setUpdateAt(LocalDateTime.now());

        user.isValid();
        repository.update(user);
    }


    @Override
    public void updatePassword(PasswordDto passwordDto) {
        repository.updatePassword(UUID.fromString(passwordDto.getId()), passwordDto.getNewPassword());
    }
}

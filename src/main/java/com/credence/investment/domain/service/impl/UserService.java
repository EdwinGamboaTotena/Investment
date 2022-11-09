package com.credence.investment.domain.service.impl;

import com.credence.investment.application.dto.CreateUserDto;
import com.credence.investment.application.dto.PaginatorDto;
import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UpdateUserDto;
import com.credence.investment.domain.dao.IUserRepository;
import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.domain.exception.BadRequest;
import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.IUserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class UserService implements IUserService {


    public static final String DUPLICATE_EMAIL = "El email ingresado ya existe";

    @Autowired
    IUserRepository userRepository;

    @Override
    public PaginatorDto<User> getUsersList(int page, int size) {
        Page<User> users = userRepository.getUsersList(page, size);
        PaginatorDto<User>  paginator= new PaginatorDto<>();

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
        User user = User.builder()
                .name(createUserDto.getName())
                .lastname(createUserDto.getLastname())
                .email(createUserDto.getEmail())
                .phone(createUserDto.getPhone())
                .password(createUserDto.getPassword())
                .rol(createUserDto.getRol())
                .status(StatusEnum.ACTIVE)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        try {
            return userRepository.createUser(user);
        }   catch(DataIntegrityViolationException dv) {
        System.out.println("dv = " + dv);
        throw new BadRequest(DUPLICATE_EMAIL);
    } catch(
    ConstraintViolationException ce) {
        System.out.println("ce = " + ce);
        throw new BadRequest(DUPLICATE_EMAIL);
    } catch(RuntimeException re) {
        System.out.println("re = " + re);
        throw new BadRequest(DUPLICATE_EMAIL);
    } catch (Exception e) {
        System.out.println("e = " + e);
        throw new BadRequest(DUPLICATE_EMAIL);
    }
    }

    @Override
    public User updateUser(String id, UpdateUserDto updateUserDto) {
        User user = User.builder()
                .name(updateUserDto.getName())
                .lastname(updateUserDto.getLastname())
                .phone(updateUserDto.getPhone())
                .rol(updateUserDto.getRol())
                .status(updateUserDto.getStatus())
                .updateDate(LocalDateTime.now())
                .build();

        user.setId(id);

        return userRepository.updateUser(user);
    }


    @Override
    public void updatePassword(PasswordDto passwordDto) {
        userRepository.updatePassword(UUID.fromString(passwordDto.getId()), passwordDto.getNewPassword());
    }
}

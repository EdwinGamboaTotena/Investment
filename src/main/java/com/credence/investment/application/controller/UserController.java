package com.credence.investment.application.controller;

import com.credence.investment.application.dto.CreateUserDto;
import com.credence.investment.application.dto.PaginatorDto;
import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UpdateUserDto;
import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userSer;

    @GetMapping
    public PaginatorDto<User> userList(@RequestParam int page, @RequestParam int size) {
        return userSer.getUsersList(page, size);
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable String id) {
        return userSer.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto user) {
        return userSer.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody UpdateUserDto user) {
        return userSer.updateUser(id, user);
    }

    @PatchMapping
    public void updatePassword(@RequestBody PasswordDto passwordDto) {
        userSer.updatePassword(passwordDto);
    }

}

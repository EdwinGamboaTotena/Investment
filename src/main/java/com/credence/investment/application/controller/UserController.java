package com.credence.investment.application.controller;

import com.credence.investment.application.dto.PasswordDto;
import com.credence.investment.application.dto.UserDto;
import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService IUserService;

    @GetMapping
    public List<User> userList() {
        return IUserService.getUsersList();
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable String id) {
        return IUserService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserDto user) {
        return IUserService.createUser(user);
    }

    @PatchMapping
    public void updatePassword(@RequestBody PasswordDto passwordDto) {
        IUserService.updatePassword(passwordDto);
    }

}

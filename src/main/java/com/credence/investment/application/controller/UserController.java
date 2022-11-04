package com.credence.investment.application.controller;

import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> userList() {
        return userService.getUsersList();
    }

}

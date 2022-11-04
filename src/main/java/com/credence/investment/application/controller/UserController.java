package com.credence.investment.application.controller;

import com.credence.investment.domain.model.User;
import com.credence.investment.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService IUserService;
    @GetMapping
    public List<User> userList() {
        return IUserService.getUsersList();
    }

}

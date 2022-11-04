package com.credence.investment.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class UserController {

    @Value("${test}")
    private String test;

    @GetMapping()
    public String listOfUsers() {
        return test;
    }
}

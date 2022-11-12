package com.credence.investment.application.user;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.user.User;
import com.credence.investment.domain.user.dto.CreateUserDto;
import com.credence.investment.domain.user.dto.PasswordDto;
import com.credence.investment.domain.user.dto.UpdateUserDto;
import com.credence.investment.domain.user.ports.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public PaginatorDto<User> userList(@RequestParam int page, @RequestParam int size) {
        return service.get(page, size);
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody UpdateUserDto user) {
        service.update(id, user);
    }

    @PatchMapping("/reset-password")
    public void updatePassword(@RequestBody PasswordDto passwordDto) {
        service.updatePassword(passwordDto);
    }

}

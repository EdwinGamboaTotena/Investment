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
    public void updateUser(@PathVariable String id, @RequestBody UpdateUserDto user) {
        userSer.updateUser(id, user);
    }

    @PatchMapping("/reset-password")
    public void updatePassword(@RequestBody PasswordDto passwordDto) {
        userSer.updatePassword(passwordDto);
    }

}

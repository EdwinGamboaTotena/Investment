package com.credence.investment.application.dto;

import com.credence.investment.domain.enums.RolEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserDto {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private RolEnum rol;
}

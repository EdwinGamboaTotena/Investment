package com.credence.investment.domain.user.dto;

import com.credence.investment.domain.common.enums.RolEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserDto {
    private String name;
    private String lastname;
    private String phone;
    private boolean isActive;
    private RolEnum rol;
}

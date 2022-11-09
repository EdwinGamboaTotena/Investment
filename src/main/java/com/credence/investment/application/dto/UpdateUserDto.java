package com.credence.investment.application.dto;

import com.credence.investment.domain.enums.RolEnum;
import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserDto {
    private String name;
    private String lastname;
    private String phone;
    private StatusEnum status;
    private RolEnum rol;
}

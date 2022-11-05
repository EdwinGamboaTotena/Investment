package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.RolEnum;
import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private RolEnum rol;
    private StatusEnum status;
}

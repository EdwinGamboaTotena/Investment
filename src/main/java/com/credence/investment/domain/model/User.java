package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.RolEnum;
import com.credence.investment.domain.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User {


    private String id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private RolEnum rol;
    private StatusEnum status;
}

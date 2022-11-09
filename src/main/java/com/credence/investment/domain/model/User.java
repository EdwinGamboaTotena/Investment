package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.RolEnum;
import com.credence.investment.domain.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


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

    @JsonIgnore
    private String password;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}

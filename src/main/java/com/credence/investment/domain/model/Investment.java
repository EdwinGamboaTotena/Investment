package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.infraestructure.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
public class Investment {

    private UUID id;
    private UserEntity owner;
    private double amount;
    private String currency;
    private boolean isActive = true;
    private LocalDate createDate;
    private LocalDate updateDate;
    private int periodInMonths;
    private int percentage;
    private boolean isCompoundInterest;
    private String note;
    private StatusEnum status;
}

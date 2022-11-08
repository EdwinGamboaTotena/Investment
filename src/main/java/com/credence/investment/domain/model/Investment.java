package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.infraestructure.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
public class Investment {

    private String id;
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

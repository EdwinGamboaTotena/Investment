package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.infraestructure.entity.InvestmentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Payment {

    private UUID id;
    private InvestmentEntity investment;
    private double amount;
    private String currency;
    private LocalDate createDate;
    private LocalDate updateDate;
    private boolean isAddedToCapital;
    private String note;
    private StatusEnum status;

}

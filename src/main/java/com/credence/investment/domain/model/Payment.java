package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.infraestructure.entity.InvestmentEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Payment {

    private String id;
    private InvestmentEntity investment;
    private double amount;
    private String currency;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private boolean isAddedToCapital;
    private String note;
    private StatusEnum status;

}

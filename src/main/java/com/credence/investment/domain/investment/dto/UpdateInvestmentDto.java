package com.credence.investment.domain.investment.dto;

import com.credence.investment.domain.common.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateInvestmentDto {

    private String owner;
    private double amount;
    private String currency;
    private int periodInMonths;
    private int percentagePerMoth;
    private boolean isCompoundInterest;
    private String note;
    private StatusEnum status;
}
